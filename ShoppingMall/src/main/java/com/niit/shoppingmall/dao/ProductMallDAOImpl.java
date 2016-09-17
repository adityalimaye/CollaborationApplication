package com.niit.shoppingmall.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingmall.model.ProductMall;

@EnableTransactionManagement
@Repository()
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
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			sessionFactory.getCurrentSession().save(productMall);
			// log.debug("Starting of the method save...");
			return true;
		} catch (HibernateException e) {
			// log.error("Error occured: " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<ProductMall> getList() {
		// TODO Auto-generated method stub
		System.out.println("In search of product");
		String hql = "from ProductMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		System.out.println("Method Found");
		List<ProductMall> productMallList = query.list();
		//List productMallList = query.list();
		return productMallList;
	}

	@Transactional
	public ProductMall getRowById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		ProductMall productMall = (ProductMall) session.load(ProductMall.class, id);
		return productMall;
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
	}

	@Transactional
	public String deleteRow(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ProductMall productMall = (ProductMall) session.load(ProductMall.class, id);
		session.delete(productMall);
		tx.commit();

		Serializable ids = session.getIdentifier(productMall);
		session.close();
		return (String) ids;
	}

	/*public boolean deleteRow(ProductMall productMall) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(productMall);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/
	
	

}
