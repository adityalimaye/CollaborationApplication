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
@Repository
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
	public int save(SupplierMall supplierMall) {
		// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			session.saveOrUpdate(supplierMall);
			// log.debug("Starting of the method save...");
			tx.commit();
			Serializable id = session.getIdentifier(supplierMall);
			session.close();
			return (Integer) id;
		
	}
	

	@Transactional
	public List<SupplierMall> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from SupplierMall";
		Query query = session.createQuery(hql);
		
		System.out.println("Method Found");
		List<SupplierMall> supplierMallList = query.list();
		//List supplierMallList = query.list();
		session.close();
		return supplierMallList;
	}

	@Transactional
	public SupplierMall getRowById(int id) {
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
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SupplierMall supplierMall = (SupplierMall) session.load(SupplierMall.class, id);
		session.delete(supplierMall);
		tx.commit();

		Serializable ids = session.getIdentifier(supplierMall);
		session.close();
		return (Integer) ids;
	}
}
