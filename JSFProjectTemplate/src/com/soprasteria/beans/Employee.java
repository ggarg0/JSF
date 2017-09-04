package com.soprasteria.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "employee", eager = true)
@ViewScoped
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstName = "";
	private String lastName = "";
	private String mailId = "";
	private String designation = "";
	
	public Employee() {
	}

	public Employee(String firstName, String lastName,
			String mailId, String designation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.designation = designation;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
