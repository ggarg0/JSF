package com.jsf.listeners;


import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import com.jsf.bean.UserBeanData;

public class ActionListenerTest implements ActionListener {
	@Override
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException { 
		System.out.println("Calling Action Listener Usecase");
		UserBeanData userBeanObj = (UserBeanData) FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap().get("userBeanData"); 
		userBeanObj.setMessage("JSF Action Listener Test - Using 'c:actionListener'"); 
	} 
}