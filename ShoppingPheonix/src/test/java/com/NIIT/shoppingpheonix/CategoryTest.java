/*package com.NIIT.shoppingpheonix;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.NIIT.shoppingpheonix.dao.CategoryDAO;
import com.NIIT.shoppingpheonix.model.Category;



public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		Category category = (Category) context.getBean("category");
		category.setId("CG002");
		category.setName("CGName 001");
		category.setDescription("This is category001 description");
		
		System.out.println("Hi hello how are u?");
		
		if(categoryDAO.save(category)==true){
			System.out.println("Category Created Successfully");
		}
		else{
			System.out.println("Not able to create the category");
		}
	}
}*/