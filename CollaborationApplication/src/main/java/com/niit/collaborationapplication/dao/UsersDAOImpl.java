package com.niit.collaborationapplication.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationapplication.model.Users;

@EnableTransactionManagement
@Repository(value="usersDAO")
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
		/*Session session = sessionFactory.openSession();*/ 
		String hql = "from Users";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Checking for list of users");
		@SuppressWarnings("unchecked")
		List<Users> usersList = query.list();
		//List userDetailsMallList = query.list();
		/*session.close();*/
		return usersList;
	}

	
	@Transactional
	public Users getRowById(String user_id) {
		// TODO Auto-generated method stub
		System.out.println("Getting User by Id...");
		String hql = "from Users where user_id='"+user_id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Users> userList = query.list();
		if(userList != null && !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}	
		
	
	@Transactional
	public boolean save(Users users) {
		// TODO Auto-generated method stub
	
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(users);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
	}	
			
	
	@Transactional
	public boolean updateRow(Users users) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(users);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteRow(String user_id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(user_id);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public Users authenticate(String user_id, String password) {
		// TODO Auto-generated method stub
		String hql = "from Users where id = '"+user_id+"' and password = '"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("User Checked for authentication");
		@SuppressWarnings("unchecked")
		List<Users> userAuthList = query.list();
		if(userAuthList != null && !userAuthList.isEmpty()){
			return userAuthList.get(0);
			
		}
		return null;
	}
}
