package com.niit.collaborationapplication.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="blog")
@Component
public class Blog extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5590790739273445614L;
	@Id
	private String blogID;
	private String blogName;
	private String user_id;
	private String blogDescription;
	private Character status;
	
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	
	@OneToMany(mappedBy="blog",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<BlogComment> blogComments = new HashSet<BlogComment>();
	
	public String getBlogID() {
		return blogID;
	}
	public void setBlogID(String blogID) {
		this.blogID = blogID;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
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
	
	public Set<BlogComment> getBlogComments() {
		return blogComments;
	}
	public void setBlogComments(Set<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}
	public Blog() {
		// TODO Auto-generated constructor stub\
		this.blogID = "BLG" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public Blog(String blogName, String user_id, String blogDescription, Character status,
			Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.blogName = blogName;
		this.user_id = user_id;
		this.blogDescription = blogDescription;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
	
	@Override
	public String toString() {
		return "Blog [blogID=" + blogID + ", blogName=" + blogName + ", userID=" + user_id + ", blogDescription=" + blogDescription + ", status=" + status + ",createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", blogComments=" + blogComments + "]";
	}
}
