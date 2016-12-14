package com.niit.collaborationapplication.dao;

import java.text.SimpleDateFormat;
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
	private SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean postJob(Job job) {
		// TODO Auto-generated method stub
		try {
			Date today = Calendar.getInstance().getTime();
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			job.setDate_posted(today);
	        job.setStatus('V');
			
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
	@SuppressWarnings("unchecked")
	public List<Job> getAllVacantJobs() {
		// TODO Auto-generated method stub
		String hql = "from job where status = 'V'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		String hql = "from job";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean applyForJob(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(jobApplication);
		}catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*public boolean updateJobApplication(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

	@Transactional
	public List<Job> getMyAppliedJobs(String user_id) {
		// TODO Auto-generated method stub
		String hql = "from Job where jobID in(select jobID from JobApplication where user_id = '"+user_id+"')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Job> listMyAppliedJobs = (List<Job>) query.list();
		return listMyAppliedJobs;
	}

	@Transactional
	public JobApplication getJobApplication(String user_id,long jobID) {
		// TODO Auto-generated method stub
		String hql = "from JobApplication where user_id='"+user_id+"'and jobID = "+ jobID;
		Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		@SuppressWarnings("unchecked")
		List<JobApplication> listjobsapplied = query.list();
		if(listjobsapplied!=null && !listjobsapplied.isEmpty()){
			return listjobsapplied.get(0);
		}
		return null;
	}

	@Transactional
	public boolean selectUser(String user_id, long jobID) {
		// TODO Auto-generated method stub
		try {
			String hql="UPDATE JobApplication SET status = 'S' where user_id = '"+user_id+"' and jodID="+jobID;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean callForInterview(String user_id, long jobID) {
		// TODO Auto-generated method stub
		try {
			String hql="UPDATE JobApplication SET status = 'C' where user_id = '"+user_id+"' and jodID="+jobID;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean rejectJobApplication(String user_id, long jobID) {
		// TODO Auto-generated method stub
		try {
			String hql="UPDATE JobApplication SET status = 'R' where user_id = '"+user_id+"' and jodID="+jobID;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
/*
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
			job.setStatus('V');
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


	@Transactional
	public JobApplication getJobApplication(String userID,long jobID) {
		// TODO Auto-generated method stub
		String hql = "from JobApplication where userID = '"+userID+"' and jobID = '"+jobID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
	}

	public JobApplication get(String userID, long jobID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean callForInterview(String userID, long jobID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean rejectJobApplication(String userID, long jobID) {
		// TODO Auto-generated method stub
		return false;
	}
}
*/