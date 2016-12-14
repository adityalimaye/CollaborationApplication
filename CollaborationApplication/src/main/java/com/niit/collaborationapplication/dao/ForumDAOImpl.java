package com.niit.collaborationapplication.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationapplication.model.Forum;

@EnableTransactionManagement
@Repository(value="forumDAO")
public class ForumDAOImpl implements ForumDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean createForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean deleteForum(String forumID) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(forumID);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public Forum getForumByID(String forumID) {
		// TODO Auto-generated method stub
		String hql = "from Forum where forumID='"+forumID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Checking for list of forum by forumID");
		@SuppressWarnings("unchecked")
		List<Forum> forumList1 = query.list();
		if(forumList1 !=null && !forumList1.isEmpty()){
			return forumList1.get(0);				
		}
		return null;
	}
	
	@Transactional
	public List<Forum> listAllForums() {
		// TODO Auto-generated method stub
		String hql= "from Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Checking for list of forums");
		@SuppressWarnings("unchecked")
		List<Forum> forumList2 = query.list();
		return forumList2;
	}
	
	@Transactional
	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(forum);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
