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
	public int save(CategoryMall categoryMall) {
		// TODO Auto-generated method stub
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
			
	}

	@Transactional
	public List<CategoryMall> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from CategoryMall";
		Query query = session.createQuery(hql);
		
		System.out.println("Method Found");
		List<CategoryMall> categoryMallList = query.list();
		//List productList = query.list();
		session.close();
		return categoryMallList;
	}

	@Transactional
	public CategoryMall getRowById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		CategoryMall categoryMall = (CategoryMall) session.load(CategoryMall.class, id);
		return categoryMall;
	}
	
	@Transactional
	public int updateRow(CategoryMall categoryMall) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(categoryMall);
		tx.commit();
		Serializable id = session.getIdentifier(categoryMall);
		session.close();
		return (Integer) id;
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
		session.close();
		return (Integer) ids;
	}

}
