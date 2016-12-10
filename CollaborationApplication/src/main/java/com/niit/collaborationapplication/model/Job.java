package com.niit.collaborationapplication.model;




import java.text.SimpleDateFormat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name="job")
@Component
public class Job extends BaseDomain{
	
	@Id
	@NotNull
	@GeneratedValue
	@Column(name="jobID")
	private long jobID;
	
	@NotNull
	@Column(name="job_title")
	private String job_title;
	
	@NotNull
	@Column(name="job_description")
	private String job_description;
	
	private String salary;
	private Date date_posted;
	private String qualification;
	private Character status;
	private int no_of_applications;
	
	
	
	public long getJobID() {
		return jobID;
	}
	public void setJobID(long jobID) {
		this.jobID = jobID;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public Date getDate_posted() {
		return date_posted;
	}
	public void setDate_posted(Date today) {
		if(today==null){
			new SimpleDateFormat();
		}
		this.date_posted = today;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		if(status == null){
			status = new Character('V');
		}
		this.status = status;
	}
	public int getNo_of_applications() {
		return no_of_applications;
	}
	public void setNo_of_applications(int no_of_applications) {
		this.no_of_applications = no_of_applications;
	}
	
	
}
