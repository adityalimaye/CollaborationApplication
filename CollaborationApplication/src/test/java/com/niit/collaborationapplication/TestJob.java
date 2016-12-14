/*package com.niit.collaborationapplication;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationapplication.dao.JobDAO;
import com.niit.collaborationapplication.model.Job;

public class TestJob {
	
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	Job job;
	
	
	AnnotationConfigApplicationContext context;
	
	@Before 
	public void init(){
		System.out.println("In INIT Method");
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationapplication");
		context.refresh();
		
		jobDAO = (JobDAO) context.getBean("jobDAO");
		System.out.println("In JobDAO");
		job = (Job) context.getBean("job");
		System.out.println("In Job");
	}
	
	@Test 
		public void postJob(){
		System.out.println("Trying to post a job");
		job.setJob_title("Production Manager");
		job.setJob_description("Production managers are responsible for the technical management");
		job.setSalary("3.8 to 4.5 LPA");
		job.setQualification("BE/BCS/MCS/MCA");
		job.setNo_of_applications(25);
		jobDAO.postJob(job);
		System.out.println("Job posted successfully");
		assertEquals("postJobTestCase", jobDAO.postJob(job),true);
	}
	
	@Test 
	public void applyForJob(String jobID,HttpSession session){
		System.out.println("Trying to apply for a job");
		
		
	}
}

	


*/