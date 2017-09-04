package com.jsf.listbox;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

public class UserBeanListBox{
	public String favoriteCar1;
	public String favoriteCar2;
	public String favoriteCar3;
	public String getFavoriteCar1() {
		return favoriteCar1;
	}
	public void setFavoriteCar1(String favoriteCar1) {
		this.favoriteCar1 = favoriteCar1;
	}
	public String getFavoriteCar2() {
		return favoriteCar2;
	}
	public void setFavoriteCar2(String favoriteCar2) {
		this.favoriteCar2 = favoriteCar2;
	}
	public String getFavoriteCar3() {
		return favoriteCar3;
	}
	public void setFavoriteCar3(String favoriteCar3) {
		this.favoriteCar3 = favoriteCar3;
	}
	
	//generated by map
	private static Map<String, Object> favoriteCar2Value;
	static
	{
		favoriteCar2Value = new LinkedHashMap<String, Object>();
		
		favoriteCar2Value.put("BMW Series 1 - 116", "116"); //label, value
		favoriteCar2Value.put("BMW Series 1 - 118", "118");
		favoriteCar2Value.put("BMW Series 1 - 120", "120");
	}
	
	public Map<String, Object> getFavoriteCar2Value()
	{
		return favoriteCar2Value;
	}
	
	//generated by object array
	public static class Car
	{
		public String carLabel;
		public String carValue;
		
		public Car(String carLabel, String carValue)
		{
			this.carLabel = carLabel;
			this.carValue = carValue;
		}
		
		public String getCarLabel()
		{
			return carLabel;
		}
		
		public String getCarValue()
		{
			return carValue;
		}
	}
	
	public Car[] car3List;
	
	public Car[] getFavoriteCar3Value()
	{
		car3List = new Car[3];
		
		car3List[0] = new Car("BMW Series 3 - 316", "316");
		car3List[1] = new Car("BMW Series 3 - 318", "318");
		car3List[2] = new Car("BMW Series 3 - 320", "320");
	
		return car3List;
	}
	
}