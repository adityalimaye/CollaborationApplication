/*package com.niit.shoppingmall;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingmall.dao.CategoryMallDAO;
import com.niit.shoppingmall.model.CategoryMall;


public class TestCaseCategoryMall {

	@Autowired
	CategoryMallDAO categoryMallDAO;
	
	@Autowired
	CategoryMall categoryMall;
	
	AnnotationConfigApplicationContext contextMall;
	
	@Before
	public void init(){
		System.out.println("In INIT Method!!!");
		contextMall = new AnnotationConfigApplicationContext();
		contextMall.scan("com.niit.shoppingmall");
		contextMall.refresh();
		
		categoryMallDAO = (CategoryMallDAO) contextMall.getBean("categoryMallDAO");
		System.out.println("In Category!!!");
		categoryMall = (CategoryMall) contextMall.getBean("categoryMall");
	}
	
	@Test
	public void addCatMallTestCase(){
		System.out.println("Trying to add the category");
		categoryMall.setId("CG001");
		categoryMall.setName("Asia Tour");
		categoryMall.setDescription("Research Special");
		categoryMallDAO.save(categoryMall);
		System.out.println("Category Added Successfully");
		assertEquals("addCatMallTestCase",categoryMallDAO.save(categoryMall),true);
	}
	
	@Test
	public void deleteCatMallTestCase(){
		System.out.println("Trying to delete the category");
		categoryMall.setId("66");
		assertEquals("deleteCatMallTestCase",categoryMallDAO.deleteRow("66"),true);
		
	}
}*/
