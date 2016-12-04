/*package com.niit.collaborationapplication;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationapplication.dao.UsersDAO;
import com.niit.collaborationapplication.model.Users;

import junit.framework.Assert;

public class TestUsers {

	@Autowired
	UsersDAO usersDAO;
	
	@Autowired
	Users users;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		System.out.println("In INIT Method...");
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationapplication");
		context.refresh();
		
		usersDAO = (UsersDAO) context.getBean("usersDAO");
		System.out.println("In UsersDAO");
		users = (Users) context.getBean("users");
		System.out.println("In Users");
	}
	
	@Test
	public void addUserTestCase(){
		System.out.println("Trying to create a new user");
		users.setUser_name("Rahul");
		users.setUser_id("rah123");
		users.setEmail_id("rahulm@gmail.com");
		users.setPassword("rahul123");
		users.setUser_role("Alumini");
		users.setContact_num("7245737155");
		users.setUser_address("F-24,Vihar Complex,Coimbatore");
		usersDAO.save(users);
		System.out.println("User Added Successfully");
		assertEquals("addUserTestCase",usersDAO.save(users),true);
	}

	@Test
	public void updateUserTestCase(){
		System.out.println("Trying to update a new user");
		users.setUser_name("Mugdha");
		users.setUser_id("ravi123");
		users.setEmail_id("mugkarod18@gmail.com");
		users.setPassword("mug123");
		users.setUser_role("Employee");
		users.setContact_num("9256786532");
		users.setUser_address("47,East Street,Chennai");
		usersDAO.updateRow(users);
		System.out.println("User Updated Successfully");
		assertEquals("addUserTestCase",usersDAO.updateRow(users),true);
	}
	
	@Test
	public void getAllCreateTestCase(){
		assertEquals("getAllUsersTestCase", 2, usersDAO.getList().size());
	}
	
	@Test
	public void getUserTestCase(){
		assertEquals("getAllUsersTestCase", usersDAO.getRowById("ravi123"));
	}
}
*/