package com.NIIT.shoppingpheonix.dao;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.NIIT.shoppingpheonix.model.Category;
import com.NIIT.shoppingpheonix.model.Product;
import com.NIIT.shoppingpheonix.model.Supplier;

@Repository(value="productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Product get(Product product) {
		// TODO Auto-generated method stub
		String id = null;
		String hql = "from Product where id="+"'"+id+"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		
		if(list == null){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	public java.util.List<Product> List(Product product) {
		// TODO Auto-generated method stub
		String hql = "from category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
}