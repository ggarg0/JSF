package com.jsf.crud.bean;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jsf.crud.dao.LdapDAO;


@ManagedBean
@SessionScoped
public class LoginBean {

	private String name;
	private String password;
	private String userName;

	public LoginBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String validateLoginCredentials() {
		// return UserAuthDAO.validateLoginCredentials(userName, password);

		String validationResult = "";
		try {
			if (new LdapDAO().LDAPLookup(userName, password)) {
				validationResult = "success";
			} else {
				validationResult = "login";
				FacesContext.getCurrentInstance().addMessage(
						"loginForm:loginName",
						new FacesMessage("Username Or Password Is Incorrect"));
			}

		} catch (Exception exObj) {
			validationResult = "login";
			FacesContext.getCurrentInstance().addMessage("loginForm:loginName",
					new FacesMessage("Username Or Password Is Incorrect"));
		}
		return validationResult;

	}

	

}