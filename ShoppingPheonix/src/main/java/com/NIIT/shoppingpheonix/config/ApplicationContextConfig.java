package com.NIIT.shoppingpheonix.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.NIIT.shoppingpheonix.dao.ProductDAO;
import com.NIIT.shoppingpheonix.dao.ProductDAOImpl;
import com.NIIT.shoppingpheonix.model.Category;
import com.NIIT.shoppingpheonix.model.Product;
import com.NIIT.shoppingpheonix.model.Supplier;
import com.NIIT.shoppingpheonix.model.UserDetails;

@Configuration
@ComponentScan("com.NIIT.shoppingpheonix")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Autowired
	@Bean(name="dataSource1")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
		dataSource1.setDriverClassName("org.h2.Driver");
		dataSource1.setUrl("jdbc:h2:tcp://localhost/~/NIITDB");
		dataSource1.setUsername("sa");
		dataSource1.setPassword("");
		return dataSource1;
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
	public SessionFactory getSessionFactory(DataSource dataSource1){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource1);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	/*@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory){
		return new ProductDAOImpl(sessionFactory);
	}
	*/
	
	
}