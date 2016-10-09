/*package com.niit.shoppingmall.dao;

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

import com.niit.shoppingmall.model.UserDetailsMall;

@EnableTransactionManagement
@Repository
public class UserDetailsMallDAOImpl implements UserDetailsMallDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsMallDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public UserDetailsMallDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public int save(UserDetailsMall userDetailsMall) {
		// TODO Auto-generated method stub
		
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			session.saveOrUpdate(userDetailsMall);
			// log.debug("Starting of the method save...");
			tx.commit();
			Serializable id = session.getIdentifier(userDetailsMall);
			session.close();
			return (Integer) id;
		
	}

	@Transactional
	public List<UserDetailsMall> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession(); 
		String hql = "from UserDetailsMall";
		Query query = session.createQuery(hql);
		
		System.out.println("Method Found");
		List<UserDetailsMall> userDetailsMallList = query.list();
		//Listr userDetailsMallList = query.list();
		session.close();
		return userDetailsMallList;
	}

	@Transactional
	public UserDetailsMall getRowById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UserDetailsMall userDetailsMall = (UserDetailsMall) session.load(UserDetailsMall.class, id);
		return userDetailsMall;
	}

	@Transactional
	public int updateRow(UserDetailsMall userDetailsMall) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(userDetailsMall);
		tx.commit();
		Serializable id = session.getIdentifier(userDetailsMall);
		session.close();
		return (Integer) id;
	}
	
	@Transactional
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserDetailsMall userDetailsMall = (UserDetailsMall) session.load(UserDetailsMall.class, id);
		session.delete(userDetailsMall);
		tx.commit();

		Serializable ids = session.getIdentifier(userDetailsMall);
		session.close();
		return (Integer) ids;
	}

}
*/