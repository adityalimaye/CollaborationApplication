package com.niit.shoppingmall.dao;

import java.io.Serializable;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingmall.model.ProductMall;

@EnableTransactionManagement
@Repository
public class ProductMallDAOImpl implements ProductMallDAO{
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public ProductMallDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public int save(ProductMall productMall) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(productMall);
		tx.commit();
		 
		Serializable id = session.getIdentifier(productMall);
		session.close();
		return (Integer) id;
		/*try {
			sessionFactory.getCurrentSession().save(productMall);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;*/
	}

	@Transactional
	public List<ProductMall> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from ProductMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ProductMall> productMallList = query.list();
		session.close();
		return productMallList;
		/*String hql = "from ProductMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ProductMall> productMallList = query.list();
		return productMallList;*/
	}
	
	@Transactional
	public ProductMall getRowById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		ProductMall productMall = (ProductMall) session.load(ProductMall.class, id);
		return productMall;
		/*String hql = "from ProductMall where id = '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ProductMall> productMallList = query.list();
		if(productMallList!=null && !(productMallList==null)){
			return productMallList.get(0);
		}
		return null;*/
	}
	
	@Transactional
	public int updateRow(ProductMall productMall) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(productMall);
		tx.commit();
		
		Serializable id = session.getIdentifier(productMall);
		session.close();
		
		return (Integer) id;
		/*try {
			sessionFactory.getCurrentSession().update(productMall);
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
		ProductMall productMall = (ProductMall) session.load(ProductMall.class, id);
		session.delete(productMall);
		tx.commit();
		Serializable ids = session.getIdentifier(productMall);
		session.close();
		return (Integer) ids;
		/*sessionFactory.getCurrentSession().delete(ProductMall.class);
		return false;*/
	}
	
	
}

/*
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingmall.model.ProductMall;

@EnableTransactionManagement
@Repository
public class ProductMallDAOImpl implements ProductMallDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductMallDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public ProductMallDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Transactional
	public boolean save(ProductMall productMall) {
		// TODO Auto-generated method stub
		
			try {
				sessionFactory.getCurrentSession().save(productMall);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
	}	
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			session.saveOrUpdate(productMall);
			tx.commit();
			Serializable id = session.getIdentifier(productMall);
			session.close();
			// log.debug("Starting of the method save...");
			return (Integer) id;
	
	

	@Transactional
	public List<ProductMall> getList() {
		// TODO Auto-generated method stub
		String hql = "from ProductMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ProductMall> productMallList = query.list();
		return productMallList;
	}	
		Session session= sessionFactory.openSession();
		System.out.println("In search of product");
		String hql = "from ProductMall";
		Query query = session.createQuery(hql);
		System.out.println("Method Found");
		List<ProductMall> productMallList = query.list();
		//List productMallList = query.list();
		session.close();
		return productMallList;
	

	@Transactional
	public ProductMall getRowById(int id) {
		// TODO Auto-generated method stub
		String hql = "from ProductMall where id = '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ProductMall> productMallList = query.list();
			if(productMallList!=null && !productMallList.isEmpty()){
				return productMallList.get(0);
				
			}
			return null;
	}		
		Session session = sessionFactory.openSession();
		ProductMall productMall = (ProductMall) session.load(ProductMall.class, id);
		return productMall;

	@Transactional
	public boolean updateRow(ProductMall productMall) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(productMall);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Product Details are updated");
		session.update(productMall);
		tx.commit();
		Serializable id = session.getIdentifier(productMall);
		session.close();
		return (Integer) id;
	

	@Transactional
	public boolean deleteRow(int id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(id);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ProductMall productMall = (ProductMall) session.load(ProductMall.class, id);
		session.delete(productMall);
		tx.commit();

		Serializable ids = session.getIdentifier(productMall);
		session.close();
		return (Integer) ids;
}
*/