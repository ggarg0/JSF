package com.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean @SessionScoped
public class UserBeanData {
	private String message = "JSF Listeners";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void bindingMessage(ActionEvent actionEvent) {
		message = "JSF Action Listener Test - Using Method Binding.";
	}
	public String showResult() {
		return "output";
	}
}