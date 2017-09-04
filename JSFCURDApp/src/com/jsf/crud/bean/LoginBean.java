package com.jsf.crud.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jsf.crud.dao.DatabaseDAO;
import com.jsf.crud.dao.UserAuthDAO;


@ManagedBean @SessionScoped
public class LoginBean {

	private String name;
	private String password;
	private String userName;

	public LoginBean() {}

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
	
	/* Method To Check User's Authentication Credentials */
	public String validateLoginCredentials() {
		return UserAuthDAO.validateLoginCredentials(userName, password);
	}	
}