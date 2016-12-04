package com.niit.collaborationapplication.dao;

import java.util.List;

import com.niit.collaborationapplication.model.Job;
import com.niit.collaborationapplication.model.JobApplication;

public interface JobDAO {
	public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> getAllVacantJobs();
	public List<Job> getAllJobs();
	public Job getJobDetails(Long jobID);
	
	public boolean save(JobApplication jobApplication);
	public boolean update(JobApplication jobApplication);
	public boolean applyForJob(JobApplication jobApplication);
	public boolean updateJobApplication(JobApplication jobApplication);
	public JobApplication get(String userID,Long jobID);
	public JobApplication getMyAppliedJobs(String userID);
	public JobApplication getJobApplication(String userID, Long jobID);
	

}
