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

import com.niit.shoppingmall.model.SupplierMall;

@EnableTransactionManagement
@Repository()
public class SupplierMallDAOImpl implements SupplierMallDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierMallDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public SupplierMallDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public boolean save(SupplierMall supplierMall) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			sessionFactory.getCurrentSession().saveOrUpdate(supplierMall);
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
	public List<SupplierMall> getList() {
		// TODO Auto-generated method stub
		String hql = "from SupplierMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		System.out.println("Method Found");
		List<SupplierMall> supplierMallList = query.list();
		//List supplierMallList = query.list();
		return supplierMallList;
	}

	@Transactional
	public SupplierMall getRowById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		SupplierMall supplierMall = (SupplierMall) session.load(SupplierMall.class, id);
		return supplierMall;
	}

	@Transactional
	public int updateRow(SupplierMall supplierMall) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(supplierMall);
		tx.commit();
		Serializable id = session.getIdentifier(supplierMall);
		session.close();
		return (Integer) id;
	}

	@Transactional
	public String deleteRow(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SupplierMall supplierMall = (SupplierMall) session.load(SupplierMall.class, id);
		session.delete(supplierMall);
		tx.commit();

		Serializable ids = session.getIdentifier(supplierMall);
		session.close();
		return (String) ids;
	}
}
