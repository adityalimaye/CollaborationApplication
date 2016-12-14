package com.niit.collaborationapplication.dao;

import java.util.List;


import com.niit.collaborationapplication.model.Blog;

public interface BlogDAO {
	public boolean createBlog(Blog blog);
	public boolean deleteBlog(String blogID);
	public Blog getBlogByID(String blogID);
	public List<Blog> listAllBlogs();
	public boolean updateBlog(Blog blog);
	//public List<Blog> listBlogByCreatedAt(char status);
	//public List<Blog> listofPendingBlogs(char status);
}
