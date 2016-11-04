package com.niit.collaborationapplication.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name="job_applied")
@Component
public class JobApplication {
	
	@Id
	private String j_application_id;
	
	@NotNull
	@Column(name="user_id")
	private String userID;
	
	@NotNull
	@Column(name="job_id")
	private Long jobID;
	
	@Column(name="date_applied")
	private Date dateApplied;
	
	private String remarks;
	
	private char status;

	public String getJ_application_id() {
		return j_application_id;
	}

	public void setJ_application_id(String j_application_id) {
		this.j_application_id = j_application_id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public long getJobID() {
		return jobID;
	}

	public void setJobID(long jobID) {
		this.jobID = jobID;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
}
