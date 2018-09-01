package com.aditya.ShoppingBackend3.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aditya.ShoppingBackend3.model.Category;
import com.aditya.ShoppingBackend3.model.Customer;
import com.aditya.ShoppingBackend3.model.Product;
import com.aditya.ShoppingBackend3.model.ShippingAddress;

@Configuration
@ComponentScan(basePackages="com.aditya")
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Bean("dataSource")
	public DataSource getDatabase() 
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		datasource.setUsername("system");
		datasource.setPassword("adi123");
		return datasource;
		
	}
	
	Properties getHibernateProperties() {
		
		Properties prop=new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.hbm2ddl.auto","update");
		return prop;
		
		
	} 
	
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource) 
	{
	
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(datasource);
		sessionFactory.addAnnotatedClasses(Customer.class);
		sessionFactory.addAnnotatedClasses(Category.class);
		sessionFactory.addAnnotatedClasses(Product.class);
		sessionFactory.addAnnotatedClasses(ShippingAddress.class);

		//sessionFactory.addPackage(packageName);
		sessionFactory.addProperties(getHibernateProperties());
		//here LocalSessionFactoryBuilder object is converted into SessionFactory using buildSessionFactory method
		return sessionFactory.buildSessionFactory();
		
	}
	
	@Autowired
	@Bean
	HibernateTransactionManager getTransaction(SessionFactory sessionFactory )
	{
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
		return manager;
	}
	

	

}
