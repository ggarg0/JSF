package com.jsf.datagrid;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class ProductBean {  

	private int laptopPrice;    
	private String laptopName;  
	public ArrayList<ProductBean>productList;

	public int getLaptopPrice() {
		return laptopPrice;
	}

	public void setLaptopPrice(int laptopPrice) {
		this.laptopPrice = laptopPrice;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public ArrayList<ProductBean> productsList() {
		productList = ProductOperation.getDummyProductsList(100);
		return productList;
	}
}