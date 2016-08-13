package com.NIIT.shoppingpheonix.dao;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.NIIT.shoppingpheonix.model.Category;

@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category){
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(Category category){
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(Category category){
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Category get(Category category) {
		String id = null;
		// TODO Auto-generated method stub
		String hql = "from Category where id="+"'"+id+"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		
		if(list == null){
			return null;
		}
		else{
			return list.get(0);
		}
		
	}
	
	@Transactional
	public java.util.List<Category> List(Category category) {
		// TODO Auto-generated method stub
		String hql = "from category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
}