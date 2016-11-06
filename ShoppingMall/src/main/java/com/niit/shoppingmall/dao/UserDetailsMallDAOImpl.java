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
	public String save(UserDetailsMall userDetailsMall) {
		// TODO Auto-generated method stub
			
			/*try {
				sessionFactory.getCurrentSession().save(userDetailsMall);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;*/
		
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("Its ok from this point ");
			// log.debug("Starting of the method save...");
			session.saveOrUpdate(userDetailsMall);
			// log.debug("Starting of the method save...");
			tx.commit();
			Serializable id = session.getIdentifier(userDetailsMall);
			session.close();
			return (String) id;
	}	

	@Transactional
	public List<UserDetailsMall> getList() {
		// TODO Auto-generated method stub
		/*String hql = "from UserDetailsMall";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetailsMall> userDetailsMallList = query.list();
		return userDetailsMallList;*/
		
		Session session = sessionFactory.openSession(); 
		String hql = "from UserDetailsMall";
		Query query = session.createQuery(hql);
		
		System.out.println("Method Found");
		@SuppressWarnings("unchecked")
		List<UserDetailsMall> userDetailsMallList = query.list();
		//List userDetailsMallList = query.list();
		session.close();
		return userDetailsMallList;
	}
	@Transactional
	public UserDetailsMall getRowById(String id) {
		// TODO Auto-generated method stub
		/*String hql = "from UserDetailsMall where id = '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetailsMall> userDetailsMallList = query.list();
		if(userDetailsMallList!=null && !userDetailsMallList.isEmpty()){
			return userDetailsMallList.get(0);
		}
		return null;*/
		
		/*if(userDetailsMallList==null){
			return null;
		}else{
			return userDetailsMallList.get(0);
		}*/	
		Session session = sessionFactory.openSession();
		UserDetailsMall userDetailsMall = (UserDetailsMall) session.load(UserDetailsMall.class, id);
		return userDetailsMall;
	}
	
	@Transactional
	public String updateRow(UserDetailsMall userDetailsMall) {
		// TODO Auto-generated method stub
		/*try {
			sessionFactory.getCurrentSession().update(userDetailsMall);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;*/
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(userDetailsMall);
		tx.commit();
		Serializable id = session.getIdentifier(userDetailsMall);
		session.close();
		return (String) id;
	}
	@Transactional
	public String deleteRow(String id) {
		// TODO Auto-generated method stub
		/*try {
			sessionFactory.getCurrentSession().delete(UserDetailsMall.class);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;*/
		
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
