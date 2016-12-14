package com.niit.collaborationapplication.dao;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationapplication.model.Blog;

@EnableTransactionManagement
@Repository(value="blogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public BlogDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public Blog getBlogByID(String blogID) {
		// TODO Auto-generated method stub
		String hql= "from Blog where blogID='"+blogID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Checking for list of blogs");
		@SuppressWarnings("unchecked")
		List<Blog> blogList1 = query.list();
		if(blogList1 !=null && !blogList1.isEmpty()){
			return blogList1.get(0);				
		}
		return null;
	}

	@Transactional
	public List<Blog> listAllBlogs() {
		// TODO Auto-generated method stub
		String hql= "from Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Checking for list of blogs");
		@SuppressWarnings("unchecked")
		List<Blog> blogList2 = query.list();
		return blogList2;
	}

	@Transactional
	public boolean createBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(blog);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deleteBlog(String blogID) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blogID);
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

	

	/*@Transactional
	@SuppressWarnings("unchecked")
	public List<Blog> listBlogByCreatedAt(char status) {
		// TODO Auto-generated method stub
		System.out.println("Getting blog by id");
		String hql = "from blog where status = '"+status+"' ORDER BY createdAt DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> blogList3 = query.list();
		if(blogList3 != null && !blogList3.isEmpty()){
			return (List<Blog>) blogList3.get(0);
		}
		return null;
	}

	@Transactional
	public List<Blog> listofPendingBlogs(char status) {
		// TODO Auto-generated method stub
		String hql = "from Blog where status='"+status+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> blogList4 = query.list();
		return blogList4;
	}*/
}
