package com.soprasteria.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("EmailValidator")
public class EmailValidator implements Validator{

	@Override
	public void validate(FacesContext cpntext, UIComponent comp, Object value)
			throws ValidatorException {
		
		if(value.toString().length() < 5){
			FacesMessage msg = new FacesMessage("Email ID is not valid", "Please enter correct email Id");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
