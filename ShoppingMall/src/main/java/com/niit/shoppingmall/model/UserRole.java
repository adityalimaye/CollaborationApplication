package com.niit.shoppingmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="user_roles")
@Component

public class UserRole {

	@Id
	@GeneratedValue
	@Column(name="user_role_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserDetailsMall userDetailsMall;
	
	@Column(name="role")
	private String role;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDetailsMall getUserDetailsMall() {
		return userDetailsMall;
	}

	public void setUserDetailsMall(UserDetailsMall userDetailsMall) {
		this.userDetailsMall = userDetailsMall;
	}
}
