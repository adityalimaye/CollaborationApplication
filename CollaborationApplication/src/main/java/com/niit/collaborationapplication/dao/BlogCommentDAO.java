package com.niit.collaborationapplication.dao;

import java.util.List;

import com.niit.collaborationapplication.model.BlogComment;

public interface BlogCommentDAO {
	public boolean saveBlogCommment(BlogComment blogComment);
	public boolean deleteBlogComment(String blogCommentID);
	BlogComment getBlogComment(String blogCommentID);
	List<BlogComment> listBlogComments();
	List<BlogComment> listBlogCommentByCreatedAt(String blogID);
}
