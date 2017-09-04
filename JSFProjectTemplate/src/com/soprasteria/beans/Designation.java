package com.soprasteria.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "designation", eager = true)
@ViewScoped
public class Designation implements Serializable {

	private static final long serialVersionUID = 1L;
	private String designationId = "";
	private String designationName = "";
	private String designationEmailId = "";
	private String designationDateOfBirth = "";

	

	public Designation() {
	}

	public Designation(String designationId, String designationName,
			String designationEmailId, String designationDateOfBirth) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationEmailId = designationEmailId;
		this.designationDateOfBirth=designationDateOfBirth;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public List<Designation> getDesignations() {
		return designations;
	}

	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
	}

	public String getDesignationEmailId() {
		return designationEmailId;
	}

	public void setDesignationEmailId(String designationEmailId) {
		this.designationEmailId = designationEmailId;
	}
	
	public String getDesignationDateOfBirth() {
		return designationDateOfBirth;
	}

	public void setDesignationDateOfBirth(String designationDateOfBirth) {
		this.designationDateOfBirth = designationDateOfBirth;
	}

	private List<Designation> designations = new ArrayList<Designation>();

	public void addDesignation() {

		this.getDesignations().add(
				new Designation(this.designationId, this.designationName,
						this.designationEmailId, this.designationDateOfBirth));
	}

	public void editDesignation(Designation obj) {
		obj.designationId = this.designationId;
		obj.designationName = this.designationName;
	}

	public void deleteDesignation(Designation obj) {
		this.designations.remove(obj);
	}

}
