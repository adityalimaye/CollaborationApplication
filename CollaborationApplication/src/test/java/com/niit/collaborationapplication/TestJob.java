/*package com.niit.collaborationapplication;

import static org.junit.Assert.*;


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
		job.setJob_title("Web developer");
		job.setJob_description("Web development is a broad term and covers everything to do with building websites and all the infrastructure that sits behind them. The job is still viewed as the trendy side of IT years after it first emerged.");
		job.setSalary("5.1 to 5.6 LPA");
		job.setQualification("BE/BTECH/Any Graduate/Web Designing Course Certified(60% Mandatory in Graduation)");
		job.setNo_of_applications(07);
		job.setStatus('V');
		//jobDAO.postJob(job);
		System.out.println("Job posted successfully");
		assertEquals("postJobTestCase", jobDAO.postJob(job),true);
	}
}

	


*/