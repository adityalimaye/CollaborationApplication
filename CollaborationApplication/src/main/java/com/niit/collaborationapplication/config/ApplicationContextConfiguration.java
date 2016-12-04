package com.niit.collaborationapplication.config;

import java.util.Properties;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationapplication.dao.JobDAO;
import com.niit.collaborationapplication.dao.JobDAOImpl;
import com.niit.collaborationapplication.dao.UsersDAO;
import com.niit.collaborationapplication.dao.UsersDAOImpl;
import com.niit.collaborationapplication.model.Job;
import com.niit.collaborationapplication.model.JobApplication;
import com.niit.collaborationapplication.model.Users;


@Configuration
@ComponentScan("com.niit.collaborationapplication")
@EnableTransactionManagement

public class ApplicationContextConfiguration {
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/NIITDB5");
		dataSource.setUsername("sa1");
		dataSource.setPassword("sa1");
		return dataSource;
		
	}
	
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.hbm2ddl.auto","update");
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Users.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(JobApplication.class);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Autowired
    @Bean(name = "usersDAO")
    public UsersDAO getUsersDAO(SessionFactory sessionFactory) {
    	return new UsersDAOImpl(sessionFactory);
    }
	
	@Autowired
    @Bean(name = "jobDAO")
    public JobDAO getJobDAO(SessionFactory sessionFactory) {
    	return new JobDAOImpl(sessionFactory);
    }
}
