package com.niit.collaborationapplication.controller;


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
		List<Job> jobs = jobDAO.getAllVacantJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getMyAppliedJobs/",method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getMyAppliedJobs(HttpSession httpSession){
		logger.debug("->->->-> Starting of the method getMyAppliedJobs");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		
		List<Job> jobs = (List<Job>) jobDAO.getMyAppliedJobs(loggedInUserID);
		return new ResponseEntity<List<Job>> (jobs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getJobDetails/{jobID}",method = RequestMethod.GET)
	public ResponseEntity<Job> getJobDetails(@RequestParam("jobID") Long jobID)
	{
		logger.debug("->->->-> Starting of the method getJobDetails()");
		Job job = jobDAO.getJobDetails(jobID);
		return new ResponseEntity<Job> (job,HttpStatus.OK);
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
		//jobApplication = jobDAO.getJobApplication(jobID);
		jobApplication.setJobID(jobID);
		jobApplication.setUserID(loggedInUserID);
		jobApplication.setStatus('N');
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
		jobApplication = jobDAO.getJobApplication(userID,jobID);
		
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
		jobApplication = jobDAO.getJobApplication(userID, jobID);
		
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
		jobApplication = jobDAO.getJobApplication(userID, jobID);
		
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
