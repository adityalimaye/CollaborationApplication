package com.NIIT.shoppingpheonix.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NIIT.shoppingpheonix.model.Product;

@Repository(value="productDAO")
public class ProductDAOImpl implements ProductDAO{

	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Product product) {
		// TODO Auto-generated method stub
		try {
			log.debug("Starting of the method save...");
			sessionFactory.getCurrentSession().save(product);
			log.debug("Starting of the method save...");
			return true;
		} catch (HibernateException e) {
			log.error("Error occured: "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			log.debug("Starting of the method update...");
			sessionFactory.getCurrentSession().save(product);
			log.debug("Starting of the method update...");
			return true;
		} catch (HibernateException e) {
			log.error("Error occured: "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			log.debug("Starting of the method delete...");
			sessionFactory.getCurrentSession().save(product);
			log.debug("Starting of the method delete...");
			return true;
		} catch (HibernateException e) {
			log.error("Error occured: "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Product get(String id) {
		// TODO Auto-generated method stub
		
		log.debug("Starting of the method get");
		log.info("Trying to get product based on id:"+id);
		String hql = "from Product where id="+"'"+id+"'";
		log.info("The hsql query is: "+hql);
		
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		
		if(list == null){
			log.info("No products are available with this id: "+id);
			return null;
		}
		else{
			return list.get(0);
		}
	}

	public java.util.List<Product> list() {
		// TODO Auto-generated method stub
		log.debug("Starting of the method list");
		String hql = "from product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		log.debug("Starting of the method list");
		List<Product> list = query.list();
		if(list==null  || list.isEmpty()){
			log.info("No products are available");
		}
		return query.list();
		
	}

	
}


