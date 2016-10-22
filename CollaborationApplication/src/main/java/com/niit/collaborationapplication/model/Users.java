package com.niit.collaborationapplication.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users extends BaseDomain implements Serializable{


		/**
	 * 
	 */
	private static final long serialVersionUID = 5871125583524321124L;

		@NotNull
		@NotEmpty
		@Column(name="user_name")
		private String user_name;
		
		@Id
		@Column(name="user_id")
		private String user_id;
		
		@NotNull
		@NotEmpty
		@Column(name="email_id")
		private String email_id;
		
		@NotNull
		@NotEmpty
		@Column(name="password")
		private String password;
		
		@NotNull
		@NotEmpty
		@Column(name="contact_num")
		private String contact_num;
		
		@NotNull
		@NotEmpty
		@Column(name="user_address")
		private String user_address;
		
		@NotNull
		@NotEmpty
		@Column(name="user_role")
		private String user_role;
		
		public Users() {
			// TODO Auto-generated constructor stub
		}
		
		public Users(String user_name, String user_id, String email_id, String password, String contact_num,
				String user_address, String user_role) {
			super();
			this.user_name = user_name;
			this.user_id = user_id;
			this.email_id = email_id;
			this.password = password;
			this.contact_num = contact_num;
			this.user_address = user_address;
			this.user_role = user_role;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getContact_num() {
			return contact_num;
		}

		public void setContact_num(String contact_num) {
			this.contact_num = contact_num;
		}

		public String getUser_address() {
			return user_address;
		}

		public void setUser_address(String user_address) {
			this.user_address = user_address;
		}

		public String getUser_role() {
			return user_role;
		}

		public void setUser_role(String user_role) {
			this.user_role = user_role;
		}
		
		
}
