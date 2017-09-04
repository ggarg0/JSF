package com.jsf.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * @author Andres.Cespedes
 * @version 1.0 $Date: 07/02/2015
 * @since 1.7
 *
 */
@ManagedBean(name = "managedBeanController")
@SessionScoped
public class ManagedBeanController implements Serializable {

	private int numFibonacci;
	private long result;

	/**
	 * Number for serialization
	 */
	private static final long serialVersionUID = 8150756503956053844L;

	/**
	 * No-arg constructor
	 */
	public ManagedBeanController() {
		numFibonacci = 0;
		result = 0;
	}

	/**
	 * @return the numFibonacci
	 */
	public int getNumFibonacci() {
		return numFibonacci;
	}

	/**
	 * @param numFibonacci
	 *            the numFibonacci to set
	 */
	public void setNumFibonacci(int numFibonacci) {
		this.numFibonacci = numFibonacci;
	}

	/**
	 * @return the result
	 */
	public long getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(long result) {
		this.result = result;
	}

	/**
	 * Business Operation to get the Fibonnaci N-number
	 * 
	 * @param param
	 * @return
	 */
	private long getFibonnaciNumber(int param) {
		if (param == 1 || param == 2) {
			return 1;
		}
		long actual = 1;
		long next = 1;
		long sum = 0;
		for (int i = 2; i < param; i++) {
			sum = next + actual;
			actual = next;
			next = sum;
		}
		return next;
	}

	/**
	 * Non ajax perform Fibonacci Operation
	 */
	public void performFibonnaciOperation() {
		if (numFibonacci <= 0) {
			setResult(0L);
		} else {
			setResult(getFibonnaciNumber(numFibonacci));
		}
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Fibonacci Calculation(Non AJAX call) for the " + numFibonacci
						+ " number was: " + result, "Fibonacci Calculation");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	/**
	 * Ajax perform Fibonacci Operation
	 * 
	 * @param event
	 */
	public void ajaxPerformFibonnaciOperation(final AjaxBehaviorEvent event) {
		if (numFibonacci <= 0) {
			setResult(0L);
		} else {
			setResult(getFibonnaciNumber(numFibonacci));
		}
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Fibonacci Calculation(AJAX call) for the " + numFibonacci
						+ " number was: " + result, "Fibonacci Calculation");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

}