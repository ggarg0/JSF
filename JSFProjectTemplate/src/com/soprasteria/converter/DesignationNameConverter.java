package com.soprasteria.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("DesignationNameConverter")
public class DesignationNameConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext cpntext, UIComponent comp,
			String value) {
		if (value.contains("a")) {
			FacesMessage msg = new FacesMessage("Error converting designation name.",
					"Invalid designation name.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		} else {
			return value.toString();
			}
	}

	@Override
	public String getAsString(FacesContext cpntext, UIComponent comp,
			Object valueObj) {
		return null;
	}
}
