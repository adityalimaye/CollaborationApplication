package com.niit.collaborationapplication.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationapplication.dao.JobDAO;
import com.niit.collaborationapplication.model.BaseDomain;
import com.niit.collaborationapplication.model.Job;
import com.niit.collaborationapplication.model.JobApplication;


@RestController
public class JobController{
	@Autowired 
	JobDAO jobDAO;
	
	@Autowired 
	BaseDomain baseDomain;
	
	@Autowired
	Job job;
	
	@Autowired
	JobApplication jobApplication;
	
	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@RequestMapping(value="/postAJob",method = RequestMethod.POST)
	public ResponseEntity<BaseDomain> postAJob(@RequestBody Job job){
		logger.debug("->->->-> Starting of the method postAJob");
		if(jobDAO.postJob(job)==true){
			job.setErrorCode("200");
			job.setErrorMessage("Successfully posted the job");
		}else{
			job.setErrorCode("400");
			job.setErrorMessage("Not able to post the job");
		}
		return new ResponseEntity<BaseDomain> (baseDomain,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateJob",method=RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@PathVariable("jobID") long jobID, @RequestBody Job job){
		logger.debug("->->->-> Starting of the method updateJob");
		if(jobDAO.getAllJobs()==null){
			logger.debug("Job does not exist with this jobID");
			job.setErrorMessage("Job does not exist with this jobID..."+job.getJobID());
			job = new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND); 
		}
		jobDAO.updateJob(job);
		logger.debug("Job updated successfully!!!");
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllVacantJobs",method=RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllVacantJobs(){
		logger.debug("->->->-> Starting of the method getAllVacantJobs");
		List<Job> joblist1 = jobDAO.getAllVacantJobs();
		if(joblist1.isEmpty()){
			return new ResponseEntity<List<Job>>(joblist1,HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<List<Job>> (joblist1,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllJobs(){
		logger.debug("->->->-> Starting of the method getAllJobs");
		List<Job> joblist2 = jobDAO.getAllJobs();
		if(joblist2.isEmpty()){
			return new ResponseEntity<List<Job>>(joblist2,HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<List<Job>> (joblist2,HttpStatus.OK);
	}
	
	@RequestMapping(value="/applyForJob/{jobID}",method=RequestMethod.POST)
	public ResponseEntity<JobApplication> applyForJob(@RequestParam("jobID") long jobID,HttpSession httpsession){
		logger.debug("->->->-> Starting of the method applyforJob");
		String loggedInUser = (String) httpsession.getAttribute("loggedInUser");
		jobApplication.setJobID(jobID);
		jobApplication.setUser_id(loggedInUser);
		jobApplication.setStatus('A'); //A:Applied
		if(jobDAO.applyForJob(jobApplication)!=true){
			jobApplication.setErrorCode("404");
			jobApplication.setErrorMessage("Could not apply for the job");
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NO_CONTENT); 
		}
		logger.debug("Applied for the job successfully");
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
	
	@RequestMapping(value="/selectUser/{user_id}/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<JobApplication> selectUser(@PathVariable("user_id") String user_id,@PathVariable("jobID") long jobID){
		logger.debug("->->->-> Starting of the method selectUser");
		if(jobDAO.selectUser(user_id, jobID)!=true){
			jobApplication.setErrorCode("404");
			jobApplication.setErrorMessage("The user with user_id:'"+user_id+"'is not selected for the jobID:"+jobID);
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NO_CONTENT);
		}
		logger.debug("The applicant with user_id='"+user_id+"'is selected for the job having jobID='"+jobID);
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}

	@RequestMapping(value="/callForInterview/{user_id}/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<JobApplication> callForInterview(@PathVariable("user_id") String user_id,@PathVariable("jobID") long jobID){
		logger.debug("->->->-> Starting of the method selectUser");
		if(jobDAO.callForInterview(user_id, jobID)!=true){
			jobApplication.setErrorCode("404");
			jobApplication.setErrorMessage("The applicant with user_id='"+user_id+"' and jobID='"+jobID+"'is rejected for interview");
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NO_CONTENT);
		}
		logger.debug("The applicant with user_id='"+user_id+"' and jobID='"+jobID+"'is called for interview");
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/rejectJobApplication/{user_id}/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<JobApplication> rejectJobApplication(@PathVariable("user_id") String user_id,@PathVariable("jobID") long jobID){
		logger.debug("->->->-> Starting of the method selectUser");
		if(jobDAO.rejectJobApplication(user_id, jobID)!=true){
			jobApplication.setErrorCode("404");
			jobApplication.setErrorMessage("The applicant with user_id= '"+user_id+"' is has errors in applying for the jobID='"+jobID);
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NO_CONTENT);
		}
		logger.debug("The applicant with user_id= '"+user_id+"' is rejected for the jobID='"+jobID);
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
		
	}
}
/*
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationapplication.dao.JobDAO;
import com.niit.collaborationapplication.model.BaseDomain;
import com.niit.collaborationapplication.model.Job;
import com.niit.collaborationapplication.model.JobApplication;


@RestController
public class JobController {
	
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	Job job;
	
	@Autowired
	JobApplication jobApplication;
	
	@Autowired
	BaseDomain baseDomain;
	
	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@RequestMapping(value="/getAllJobs" , method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllJobs(){
		
		List<Job> allJobs = jobDAO.getAllJobs();
		
		if(allJobs==null){
			Job job = new Job();
			job.setErrorCode("404");
			job.setErrorMessage("No jobs are available");
			allJobs.add(job);
		}
		return new ResponseEntity<List<Job>> (allJobs,HttpStatus.OK);
	 
	}
	
	@RequestMapping(value="/getAllVacantJobs/",method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllVacantJobs(){
		logger.debug("->->->->Starting of the method get all vacant jobs");
		List<Job> jobs1 = jobDAO.getAllVacantJobs();
		return new ResponseEntity<List<Job>>(jobs1,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getMyAppliedJobs/",method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getMyAppliedJobs(HttpSession httpSession){
		logger.debug("->->->-> Starting of the method getMyAppliedJobs");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		
		@SuppressWarnings("unchecked")
		List<Job> jobs2 = (List<Job>) jobDAO.getMyAppliedJobs(loggedInUserID);
		return new ResponseEntity<List<Job>> (jobs2,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getJobDetails/{jobID}",method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getJobDetails(@PathVariable("jobID") Long jobID)
	{
		logger.debug("->->->-> Starting of the method getJobDetails()");
		List<Job> jobs3 = jobDAO.getJobDetails(jobID);
		return new ResponseEntity<List<Job>> (jobs3,HttpStatus.OK);
	}
	
	@RequestMapping(value="/postAJob",method = RequestMethod.POST)
	public ResponseEntity<BaseDomain> postAJob(@RequestBody Job job){
		if(jobDAO.postJob(job)==true){
			job.setErrorCode("200");
			job.setErrorMessage("Successfully posted the job");
		}else{
			job.setErrorCode("400");
			job.setErrorMessage("Not able to post the job");
		}
		return new ResponseEntity<BaseDomain> (baseDomain,HttpStatus.OK);
	}
	
	@RequestMapping(value="/applyForJob/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<Job>  applyForJob(@RequestParam("jobID") Long jobID,HttpSession httpSession){
		logger.debug("Starting of the method applyForTheJob");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		jobApplication = jobDAO.getJobApplication(userID,jobID);
		jobApplication.setJobID(jobID);
		jobApplication.setUserID(loggedInUserID);
		jobApplication.setStatus('A');	//Applied
		if(jobDAO.save(jobApplication)){
			job.setErrorCode("404");
			job.setErrorMessage("Not able to apply for the job");
			logger.debug("Not able to apply for the job");
		}
		return new ResponseEntity<Job> (job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/selectUser/{userID}/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<Job> selectUser(@PathVariable("userID") String userID,@PathVariable("jobID") Long jobID){
		logger.debug("->->->-> Starting of the method selectUser");
		jobApplication = jobDAO.getJobApplication1(userID,jobID);
		
		jobApplication.setStatus('S');
		if(jobDAO.save(jobApplication)){
			job.setErrorCode("404");
			job.setErrorMessage("Not able to change the application status as 'selected'");
			logger.debug("Not able to change the application status as 'selected'");
		}
		return new ResponseEntity<Job> (job,HttpStatus.OK); 
	}

	@RequestMapping(value="/canCallForInterview/{userID}/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<Job> callForInterview(@PathVariable("userID") String userID,@PathVariable("jobID") Long jobID){
		logger.debug("->->->-> Starting of the method canCallForInterview");
		jobApplication = jobDAO.getJobApplication1(userID, jobID);
		
		jobApplication.setStatus('C');
		if(jobDAO.save(jobApplication)){
			job.setErrorCode("404");
			job.setErrorMessage("Not able to change the application status as 'call for interview'");
			logger.debug("Not able to change the application status as 'call for interview'");
		}
		return new ResponseEntity<Job> (job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rejectJobApplication/{userID/{jobID}",method=RequestMethod.PUT)
	public ResponseEntity<Job> rejectJobApplication(@PathVariable("userID") String userID,@PathVariable("jobID") Long jobID){
		logger.debug("->->->-> Starting of the method rejectJobAppplication");
		jobApplication = jobDAO.getJobApplication1(userID, jobID);
		
		jobApplication.setStatus('R');
		if(jobDAO.updateJobApplication(jobApplication)==false){
			job.setErrorCode("404");
			job.setErrorMessage("Not able to reject the job");
		}else{
			job.setErrorCode("200 OK");
			job.setErrorMessage("Successfully updated the status as Rejected");
		}
		return new ResponseEntity<Job> (job,HttpStatus.OK);
		
	}

}
*/