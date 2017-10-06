package com.jsf.crud.dao;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.jsf.crud.bean.StudentBean;

public class LdapDAO {	
	public void addEntry(StudentBean student) {
		
		Properties initilaProperties = new Properties();
		initilaProperties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		initilaProperties.put(Context.PROVIDER_URL, "ldap://localhost:10389");
		
		try {
			DirContext context = new InitialDirContext(initilaProperties);
			addUser(context, student);
			context.close();
		} catch (NamingException e) {
			System.out.println("LDAP addEntry Failed");
		}

	}

	public void addUser(DirContext context, StudentBean student) {
		String principal = "uid="+ student.getUsername() +", ou=dev,o=myuser";
		Attributes attributes = new BasicAttributes();
		Attribute attribute = new BasicAttribute("objectClass");
		attribute.add("inetOrgPerson");
		attributes.put(attribute);
		Attribute sn = new BasicAttribute("sn");
		Attribute cn = new BasicAttribute("cn");
		cn.add(student.getName());
		sn.add(student.getName().substring(student.getName().lastIndexOf(" ")+1));
		attributes.put(sn);
		attributes.put(cn);
		attributes.put("telephoneNumber", "777777777");
		attributes.put("userPassword", "pass");
		attributes.put("userid", principal);
		try {
			context.createSubcontext(
					"uid="+ student.getUsername()+",ou=dev", attributes);
		} catch (NamingException e) {
			System.out.println("LDAP addUser Failed");
		}
	}
	
	public boolean LDAPLookup(String user, String password) {
		Properties properties = new Properties();
		String principal = "uid="+ user +", ou=dev,o=myuser";
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		properties.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=myuser");
		properties.put(Context.SECURITY_AUTHENTICATION, "simple");
		properties.put(Context.SECURITY_PRINCIPAL, principal); 
		properties.put(Context.SECURITY_CREDENTIALS, password);
		boolean isValidUser = false;
		try {
			DirContext context = new InitialDirContext(properties);
			isValidUser = context != null;	
			Attributes attrs = context.getAttributes("uid=ggarg, ou=dev");					
		} catch (NamingException e) {
			System.out.println("LDAP Authentication Failed");
		}
		return isValidUser;
	}
}
