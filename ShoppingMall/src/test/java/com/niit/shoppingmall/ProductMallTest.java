package com.niit.shoppingmall;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingmall.dao.ProductMallDAO;
import com.niit.shoppingmall.model.ProductMall;

public class ProductMallTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext contextMall = new AnnotationConfigApplicationContext();
		contextMall.scan("com.niit.shoppingmall");
		contextMall.refresh();
		
		ProductMallDAO productMallDAO = (ProductMallDAO) contextMall.getBean("productMallDAO");
		
		ProductMall productMall = (ProductMall) contextMall.getBean("productMall");
		
		productMall.setId("PR52");
		productMall.setName("Jaipur");
		productMall.setDescription("7N8D");
		productMall.setPrice(26000.00);
		
		System.out.println("You are inside ProductMall Test!!!");
		
		if(productMallDAO.save(productMall)==true){
			System.out.println("Product Created Successfully");
		}
		else{
			System.out.println("Not able to create the product");
		}
	}

}
