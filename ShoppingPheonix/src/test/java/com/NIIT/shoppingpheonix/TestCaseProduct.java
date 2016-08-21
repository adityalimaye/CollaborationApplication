package com.NIIT.shoppingpheonix;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.NIIT.shoppingpheonix.dao.ProductDAO;
import com.NIIT.shoppingpheonix.model.Product;



public class TestCaseProduct {

	//To write a test case for Product, we need ProductDAO and product object.
	
		@Autowired
		ProductDAO productDAO;
		
		@Autowired
		Product product;
		
		AnnotationConfigApplicationContext context;
		
		//You can write a method to initialize the objects/methods.
		
		@Before
		public void init(){
			context = new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			
			productDAO = (ProductDAO) context.getBean("productDAO");
			
			product = (Product) context.getBean("productDAO");
		}
		
		@Test
		public void addProductTestCase(){
			product.setId("MOB_002");
			product.setName("Samsung");
			product.setPrice(34000);
			productDAO.save(product);
			
			assertEquals("addProductTestCase", productDAO.save(product), true);
		}
		
		
		public void deleteProductTestCase(){
			
			product.setId("PRD_002");
			
			boolean flag = productDAO.delete(product);
			
			assertEquals("deleteProductTestCase", flag, false);
		}

}
