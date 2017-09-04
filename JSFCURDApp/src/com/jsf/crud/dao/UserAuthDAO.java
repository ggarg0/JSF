package com.jsf.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.jsf.crud.bean.LoginBean;


public class UserAuthDAO {

	
	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;


	/* Method To Establish Database Connection */
	public static Connection getConnection(){  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");     
			String db_url ="jdbc:oracle:thin:@localhost:1521:admin",
					db_userName = "hr",
					db_password = "hr";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}
	
	/* Method To Check User's Authentication Credentials */
	public static String validateLoginCredentials(String user, String password) {
		String validationResult = "";
		LoginBean obj = new LoginBean();
		try {
			stmtObj = getConnection().createStatement();  
			String Query = "select * from students where student_name = '"+ user + "' and student_password = '" + password +"'";
			
			resultSetObj = stmtObj.executeQuery(Query);
									
			if (resultSetObj.next()) {
				validationResult ="success";
			}else{
				validationResult = "login";
				FacesContext.getCurrentInstance().addMessage("loginForm:loginName", new FacesMessage("Username Or Password Is Incorrect"));	
			}
			System.out.println("Total Records Fetched: " + resultSetObj.getFetchSize());
		
			connObj.close();
		} catch(Exception exObj) {
			validationResult = "login";
			FacesContext.getCurrentInstance().addMessage("loginForm:loginName", new FacesMessage("Username Or Password Is Incorrect"));			
		}
		return validationResult;
	}
}