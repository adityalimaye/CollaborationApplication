package com.niit.shoppingmall;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingmall.dao.CategoryMallDAO;
import com.niit.shoppingmall.model.CategoryMall;

public class CategoryMallTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext contextMall = new AnnotationConfigApplicationContext();
		contextMall.scan("com.niit.shoppingmall");
		contextMall.refresh();
		
		CategoryMallDAO categoryMallDAO = (CategoryMallDAO) contextMall.getBean("categoryMallDAO");
		
		CategoryMall categoryMall = (CategoryMall) contextMall.getBean("categoryMall");
		
		categoryMall.setId("CGM16");
		categoryMall.setName(" CGName Sixteen");
		categoryMall.setDescription("This is CGM16 category");
		
		System.out.println("You are Inside CategoryMallTest!!!");
		
		if(categoryMallDAO.save(categoryMall)==true){
			System.out.println("Category Created Successfully");
		}
		else{
			System.out.println("Not able to create the category");
		}
	}

}
