package com.jsf.datagrid;

import java.util.ArrayList;

public class ProductOperation {

	private final static String[] laptopName;
	private final static int[] laptopCost;

	static {
		laptopName = new String[10];
		laptopName[0] = "Hewlett-Packard";
		laptopName[1] = "Dell";
		laptopName[2] = "Lenevo";
		laptopName[3] = "Acer";
		laptopName[4] = "Sony";
		laptopName[5] = "Apple";
		laptopName[6] = "Microsoft";
		laptopName[7] = "Samsung";
		laptopName[8] = "Asus";
		laptopName[9] = "Razer";

		laptopCost = new int[10];
		laptopCost[0] = 250;
		laptopCost[1] = 300;
		laptopCost[2] = 280;
		laptopCost[3] = 260;
		laptopCost[4] = 900;
		laptopCost[5] = 400;
		laptopCost[6] = 800;
		laptopCost[7] = 100;
		laptopCost[8] = 500;
		laptopCost[9] = 600;
	}

	public static ArrayList<ProductBean> getDummyProductsList(int productRecords) {
		ArrayList<ProductBean> productsList = new ArrayList<ProductBean>();    
		for(int i = 0 ; i < productRecords ; i++) {
			ProductBean pObj = new ProductBean();
			pObj.setLaptopName(getRandomLaptopName());
			pObj.setLaptopPrice(getRandomLaptopCost());
			productsList.add(pObj);
		}		
		return productsList;
	}

	private static String getRandomLaptopName() {
		return laptopName[(int) (Math.random() * 10)];
	}   

	private static int getRandomLaptopCost() {
		return laptopCost[(int) (Math.random() * 10)];
	}
}