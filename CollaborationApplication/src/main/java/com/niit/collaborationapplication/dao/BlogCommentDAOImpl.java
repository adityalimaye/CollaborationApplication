package com.niit.collaborationapplication.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationapplication.model.BlogComment;
@EnableTransactionManagement
@Repository(value="blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO{
	
	@Autowired 
	SessionFactory sessionFactory;
	
	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveBlogCommment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean deleteBlogComment(String blogCommentID) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blogCommentID);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public BlogComment getBlogComment(String blogCommentID) {
		// TODO Auto-generated method stub
		System.out.println("Getting blogComment by ID...");
		String hql="from blogcomment where blogCommentID='"+blogCommentID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogComment> blogCommentList = query.list();
		if(blogCommentList !=null && !blogCommentList.isEmpty()){
			return blogCommentList.get(0);
		}
		return null;
	}
	@Transactional
	public List<BlogComment> listBlogComments() {
		// TODO Auto-generated method stub
		System.out.println("Getting blogComment by ID...");
		String hql="from blogcomment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogComment> blogCommentList = query.list();
		return blogCommentList;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<BlogComment> listBlogCommentByCreatedAt(String blogID) {
		// TODO Auto-generated method stub
		String hql = "from blogcomment where blog.blogID='"+blogID+"' ORDER BY commentedAt DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogComment> listOfBlogComments = query.list();
		if(listOfBlogComments !=null && !listOfBlogComments.isEmpty()){
			return (List<BlogComment>) listOfBlogComments.get(0);
		}
		return null;
	}
}
