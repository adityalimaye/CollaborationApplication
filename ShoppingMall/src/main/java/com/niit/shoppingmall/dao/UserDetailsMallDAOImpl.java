/*package com.niit.shoppingmall.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
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
@Repository()
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
	
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Transactional
	public boolean save(UserDetailsMall userDetailsMall) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			sessionFactory.getCurrentSession().saveOrUpdate(userDetailsMall);
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
	public List<UserDetailsMall> getList() {
		// TODO Auto-generated method stub
		String hql = "from UserDetailsMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		System.out.println("Method Found");
		List<UserDetailsMall> userDetailsMallList = query.list();
		//Listr userDetailsMallList = query.list();
		return userDetailsMallList;
	}

	@Transactional
	public UserDetailsMall getRowById(String id) {
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
	public String deleteRow(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserDetailsMall userDetailsMall = (UserDetailsMall) session.load(UserDetailsMall.class, id);
		session.delete(userDetailsMall);
		tx.commit();

		Serializable ids = session.getIdentifier(userDetailsMall);
		session.close();
		return (String) ids;
	}
}
		
		
	


*/