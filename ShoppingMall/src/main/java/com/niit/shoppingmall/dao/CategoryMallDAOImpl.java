package com.niit.shoppingmall.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingmall.model.CategoryMall;

@EnableTransactionManagement
@Repository
public class CategoryMallDAOImpl implements CategoryMallDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryMallDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public CategoryMallDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public int save(CategoryMall categoryMall) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 session.saveOrUpdate(categoryMall);
		 tx.commit();
		 Serializable id = session.getIdentifier(categoryMall);
		 session.close();
		 return (Integer) id;
		/*try {
			sessionFactory.getCurrentSession().save(categoryMall);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;*/
	}
	
	@Transactional
	public List<CategoryMall> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from CategoryMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<CategoryMall> categoryMallList = query.list();
		session.close();
		return categoryMallList;
	}
	
	@Transactional
	public CategoryMall getRowById(int id) {
		// TODO Auto-generated method stub
		 Session session= sessionFactory.openSession();
		 CategoryMall categoryMall = (CategoryMall) session.load(CategoryMall.class, id);
		 return categoryMall;
		/*String hql = "from CategoryMall where id = '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<CategoryMall> categoryMallList = query.list();
		if(categoryMallList!=null && !(categoryMallList==null)){
			return categoryMallList.get(0);
		}
		return null;*/
	}
	
	@Transactional
	public int updateRow(CategoryMall categoryMall) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(categoryMall);
		tx.commit();
		
		Serializable id = session.getIdentifier(categoryMall);
		sessionFactory.close();
		
		return (Integer) id;
		/*try {
			sessionFactory.getCurrentSession().update(categoryMall);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;*/
	}
	
	@Transactional
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 CategoryMall categoryMall = (CategoryMall) session.load(CategoryMall.class, id);
		 session.delete(categoryMall);
		 tx.commit();
		 
		 Serializable ids = session.getIdentifier(categoryMall);
		 sessionFactory.close();
		 return (Integer) ids;
		/*try {
			sessionFactory.getCurrentSession().delete(CategoryMall.class);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;*/
	}
	
	
}
/*
import java.io.Serializable;
import java.util.List;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingmall.model.CategoryMall;

@EnableTransactionManagement
@Repository
public class CategoryMallDAOImpl implements CategoryMallDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryMallDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public CategoryMallDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public boolean save(CategoryMall categoryMall) {
		// TODO Auto-generated method stub
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(categoryMall);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
	}	
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
				
			System.out.println("Its ok form this point ");
			// log.debug("Starting of the method save...");
			session.saveOrUpdate(categoryMall);
			// log.debug("Starting of the method save...");
			tx.commit();
			Serializable id = session.getIdentifier(categoryMall);
			session.close();
			return (Integer) id;
			
	

	@Transactional
	public List<CategoryMall> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from CategoryMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		System.out.println("Method Found");
		@SuppressWarnings("unchecked")
		List<CategoryMall> categoryMallList = query.list();
		//List productList = query.list();
		session.close();
		return categoryMallList;
	}

	@Transactional
	public CategoryMall getRowById(int id) {
		// TODO Auto-generated method stub
		String hql = "from CategoryMall where id = '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<CategoryMall> categoryMallList = query.list();
		Session session = sessionFactory.openSession();
		CategoryMall categoryMall = (CategoryMall) session.load(CategoryMall.class, id);
		return categoryMall;
		if(categoryMallList!=null && !categoryMallList.isEmpty()){
			return categoryMallList.get(0);
		}
		return null;
	}	
		if(categoryMallList==null){
			return null;
		}else{
			return categoryMallList.get(0);
		}
	
	
	@Transactional
	public boolean updateRow(CategoryMall categoryMall) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(categoryMall);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(categoryMall);
		tx.commit();
		Serializable id = session.getIdentifier(categoryMall);
		session.close();
		return (Integer) id;
	

	@Transactional
	public boolean deleteRow(int id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete("categoryMall");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CategoryMall categoryMall = (CategoryMall) session.load(CategoryMall.class, id);
		session.delete(categoryMall);
		tx.commit();

		Serializable ids = session.getIdentifier(categoryMall);
		session.close();
		return (String) ids;
}
*/