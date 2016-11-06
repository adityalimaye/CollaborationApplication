package com.niit.shoppingmall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="users")
@Component
public class UserDetailsMall implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2873477813319042114L;
	
	@NotEmpty
	@NotNull
	@Column(name="username")
	private String name;	
	
	@Id
	@Column(name="user_id")
	private String id;
	
	@NotEmpty
	@NotNull
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	
	
	@NotEmpty
	@NotNull
	@Column(name="contact")
	private String contact;
	
	@NotEmpty
	@NotNull
	@Column(name="email_id")
	private String email_id;
	
	@NotEmpty
	@NotNull
	@Column(name="user_address")
	private String user_address;
	
	@Column(name="imagepath")
	private String imagepath;
	
	@Transient
	private MultipartFile fileData;
	
	public UserDetailsMall() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDetailsMall(String name, String id, String password, boolean enabled, String contact, String email_id, String user_address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.contact = contact;
		this.email_id = email_id;
		this.user_address = user_address;
	}
	
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
}