package com.niit.collaborationapplication.dao;

import java.util.List;

import com.niit.collaborationapplication.model.Job;
import com.niit.collaborationapplication.model.JobApplication;

public interface JobDAO {
	public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> getAllVacantJobs();
	public List<Job> getAllJobs();
	
	public boolean applyForJob(JobApplication jobApplication);
	/*public boolean updateJobApplication(JobApplication jobApplication);*/
	public List<Job> getMyAppliedJobs(String user_id);
	public JobApplication getJobApplication(String user_id,long jobID);
	
	public boolean selectUser(String user_id,long jobID);
	public boolean callForInterview(String user_id,long jobID);
	public boolean rejectJobApplication(String user_id,long jobID);

}
