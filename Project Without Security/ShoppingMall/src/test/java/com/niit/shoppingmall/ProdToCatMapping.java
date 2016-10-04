/*package com.niit.shoppingmall;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.niit.shoppingmall.model.CategoryMall;
import com.niit.shoppingmall.model.ProductMall;

public class ProdToCatMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CategoryMall category = new CategoryMall();
		
		ProductMall product = new ProductMall();
		ProductMall product2 = new ProductMall();
		
		product.setName("Japan");
		product2.setName("Thiland");
		
		category.setName("International Tours");
		category.getProductMall().add(product);
		category.getProductMall().add(product2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(product);
		session.saveOrUpdate(product2);
		session.saveOrUpdate(category);
		
		session.getTransaction().commit();
		session.close();
	}

}
*/