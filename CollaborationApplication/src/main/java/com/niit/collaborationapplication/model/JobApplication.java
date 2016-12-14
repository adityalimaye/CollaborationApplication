package com.niit.collaborationapplication.model;



import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name="job_applied")
@Component
public class JobApplication extends BaseDomain{
	
	@Id
	@GeneratedValue
	@NotNull
	private String j_application_id;
	
	@NotNull
	@Column(name="user_id")
	private String user_id;
	
	@NotNull
	@Column(name="jobID")
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Long getJobID() {
		return jobID;
	}

	public void setJobID(Long jobID) {
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
