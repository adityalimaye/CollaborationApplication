package com.niit.collaborationapplication.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="forumcomment")
@Component
public class ForumComment extends BaseDomain{

	@Id
	private String forumCommentID;
	private String user_id;
	private String forumCommentContent;
	
	private Timestamp commentedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="forumID")
	@JsonBackReference
	private Forum forum;

	public String getForumCommentID() {
		return forumCommentID;
	}

	public void setForumCommentID(String forumCommentID) {
		this.forumCommentID = forumCommentID;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getForumCommentContent() {
		return forumCommentContent;
	}

	public void setForumCommentContent(String forumCommentContent) {
		this.forumCommentContent = forumCommentContent;
	}

	public Timestamp getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(Timestamp commentedAt) {
		this.commentedAt = commentedAt;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	public ForumComment() {
		// TODO Auto-generated constructor stub
	}

	public ForumComment(String user_id, String forumCommentContent, Timestamp commentedAt) {
		super();
		this.user_id = user_id;
		this.forumCommentContent = forumCommentContent;
		this.commentedAt = commentedAt;
	}
}
