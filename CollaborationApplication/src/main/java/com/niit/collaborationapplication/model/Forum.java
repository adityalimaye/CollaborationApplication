package com.niit.collaborationapplication.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="forum")
@Component
public class Forum extends BaseDomain{
	
	@Id
	private String forumID;
	private String forumName;
	private String user_id;
	private String forumDescription;
	private Character status;
	
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	
	@OneToMany(mappedBy="forum",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ForumComment> forumComments = new HashSet<ForumComment>();
	
	public String getForumID() {
		return forumID;
	}
	public void setForumID(String forumID) {
		this.forumID = forumID;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getForumDescription() {
		return forumDescription;
	}
	public void setForumDescription(String forumDescription) {
		this.forumDescription = forumDescription;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	public Set<ForumComment> getForumComments() {
		return forumComments;
	}
	public void setForumComments(Set<ForumComment> forumComments) {
		this.forumComments = forumComments;
	}
	
	public Forum() {
		// TODO Auto-generated constructor stub
	}
	public Forum(String forumName, String user_id, String forumDescription, Character status,
			Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.forumName = forumName;
		this.user_id = user_id;
		this.forumDescription = forumDescription;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	
	
}
