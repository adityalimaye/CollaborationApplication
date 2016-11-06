package com.niit.shoppingmall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


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
	
	public UserDetailsMall() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserDetailsMall(String name, String id, String password, boolean enabled, String contact, String email_id,
			String user_address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.contact = contact;
		this.email_id = email_id;
		this.user_address = user_address;
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





/*@Entity
@Table(name="userdetails")
@Component
public class UserDetailsMall {
	
	@Id
	@Column(name="id")
	private String id;
	
	private String name;
	@Column(name = "mail_id")
	private String mailID;
	
	private String address;
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "contact_number")
	private String contactNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}*/
