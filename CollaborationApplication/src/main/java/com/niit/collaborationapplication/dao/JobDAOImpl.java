package com.niit.collaborationapplication.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.collaborationapplication.model.Job;
import com.niit.collaborationapplication.model.JobApplication;

@EnableTransactionManagement
@Repository
public class JobDAOImpl implements JobDAO{
	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	
	public JobDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	
	@Transactional
	public boolean postJob(Job job) {
		// TODO Auto-generated method stub
		try {
			//job.setJob_id(getMaxID()+1);
			Date today = Calendar.getInstance().getTime();
			sessionFactory.getCurrentSession().save(job);
			job.setDate_posted(today);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(job);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public List<Job> getAllVacantJobs() {
		// TODO Auto-generated method stub
		String hql = "from Job where status = 'V' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Transactional
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		String hql = "from Job";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Transactional
	public Job getJobDetails(Long jobID) {
		// TODO Auto-generated method stub
		String hql = "from Job where jobID = '"+jobID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Job) query.list();
	}
	
	@Transactional
	public boolean applyForJob(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(jobApplication);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean updateJobApplication(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public JobApplication get(String userID, Long jobID) {
		// TODO Auto-generated method stub
		String hql = "from JobApplication where userID = '"+userID+"'and jobID = '"+jobID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
	}
	
	@Transactional
	public JobApplication getMyAppliedJobs(String userID) {
		// TODO Auto-generated method stub
		String hql = "from Job where job_id in(select jobID from JobApplication where userID = '"+userID+"')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
	}



	public JobApplication getJobApplication(String userID,Long jobID) {
		// TODO Auto-generated method stub
		String hql = "from JobApplication where userID = '"+userID+"' and jobID = '"+jobID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
	}



	public boolean save(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(jobApplication);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}



	
	
	
}
