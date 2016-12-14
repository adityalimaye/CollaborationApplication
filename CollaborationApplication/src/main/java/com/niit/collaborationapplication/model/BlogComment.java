package com.niit.collaborationapplication.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
@Table(name="blogcomment")
@Component
public class BlogComment extends BaseDomain{
	
	@Id
	private String blogCommentID;
	private String user_id;
	private String blogCommentContent;
	
	private Timestamp commentedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="blogID")
	@JsonBackReference
	private Blog blog;

	public String getBlogCommentID() {
		return blogCommentID;
	}

	public void setBlogCommentID(String blogCommentID) {
		this.blogCommentID = blogCommentID;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBlogCommentContent() {
		return blogCommentContent;
	}

	public void setBlogCommentContent(String blogCommentContent) {
		this.blogCommentContent = blogCommentContent;
	}

	public Timestamp getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(Timestamp commentedAt) {
		this.commentedAt = commentedAt;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}	
	
	public BlogComment() {
		// TODO Auto-generated constructor stub
		//this.blogCommentID = "BLGCMT" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public BlogComment(String user_id, String blogCommentContent, Timestamp commentedAt) {
		super();
		this.user_id = user_id;
		this.blogCommentContent = blogCommentContent;
		this.commentedAt = commentedAt;
	}
	
	/*@Override
	public String toString(){
		return "BlogComment [blogCommentID=" + blogCommentID + ", userID=" + user_id + ", blogCommentContent=" + blogCommentContent + ", commentedAt=" + commentedAt + ",blog=" + blog + "]";
	}*/
}
