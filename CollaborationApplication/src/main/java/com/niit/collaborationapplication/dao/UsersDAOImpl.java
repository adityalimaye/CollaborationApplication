package com.niit.collaborationapplication.dao;

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

import com.niit.collaborationapplication.model.Users;

@EnableTransactionManagement
@Repository
public class UsersDAOImpl implements UsersDAO{
	
	@Autowired 
	public SessionFactory sessionFactory;
	
	public UsersDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public UsersDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Users> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession(); 
		String hql = "from Users";
		Query query = session.createQuery(hql);
		
		System.out.println("Checking for list of users");
		List<Users> usersList = query.list();
		//List userDetailsMallList = query.list();
		session.close();
		return usersList;
	}
	
	@Transactional
	public Users getRowById(String user_id) {
		// TODO Auto-generated method stub
		System.out.println("Getting User by Id...");
		Session session = sessionFactory.openSession();
		Users users = (Users) session.load(Users.class, user_id);
		return users;
	}	
		
	
	@Transactional
	public String save(Users users) {
		// TODO Auto-generated method stub
	
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("Its ok from this point ");
			session.saveOrUpdate(users);
			tx.commit();
			Serializable users_id = session.getIdentifier(users);
			session.close();
			return (String) users_id;
	}
	
	

	@Transactional
	public String updateRow(Users users) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(users);
		tx.commit();
		Serializable users_id = session.getIdentifier(users);
		session.close();
		return (String) users_id;
	}

	@Transactional
	public String deleteRow(String user_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Users users = (Users) session.load(Users.class, user_id);
		session.delete(users);
		System.out.println("User with id: "+user_id+" deleted successfully");
		tx.commit();

		Serializable users_ids = session.getIdentifier(users);
		session.close();
		return (String) users_ids;
	}
	
	@Transactional
	public Users authenticate(String user_id, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Users where id = '"+user_id+"'and"+"password = '"+password+"'";
		Query query = session.createQuery(hql);
		
		List<Users> userAuthList = query.list();
		session.close();
		if(userAuthList != null && !userAuthList.isEmpty()){
			return userAuthList.get(0);
		}
		return null;
	}
}
