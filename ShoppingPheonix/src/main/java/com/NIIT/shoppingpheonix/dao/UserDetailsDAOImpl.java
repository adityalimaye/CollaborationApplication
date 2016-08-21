package com.NIIT.shoppingpheonix.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NIIT.shoppingpheonix.model.UserDetails;

@Repository(value="userdetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public boolean save(UserDetails userdetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(userdetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(UserDetails userdetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(UserDetails userdetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public UserDetails get(String id) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		String hql = "from Category where id="+"'"+id+"'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		
		if(list == null){
			return null;
		}
		else{
			return list.get(0);
		}
	}

	public java.util.List<UserDetails> list() {
		// TODO Auto-generated method stub
		String hql = "from category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	
	
	
}
