package com.spring.orm;

import java.util.Properties;



import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.spring.orm.entities.Person;

@Configuration
@ComponentScan("com.spring.orm.dao")
public class PersonConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties properties=new Properties();
		properties.setProperty("hibernateDialect", "org.hibernate.dialect.MySQL57Dialect");
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernnate.hbm2ddl.auto", "update");
		sessionFactory.setHibernateProperties(properties);
		sessionFactory.setAnnotatedClasses(Person.class);
		return sessionFactory;
	}
	
	@Bean 
	public HibernateTransactionManager getHibernateTransactionManager()
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
		return hibernateTransactionManager;
	}
	
	@Bean({"hibernateTemlate"})
	public HibernateTemplate getHibernateTemplate()
	{
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(getSessionFactory().getObject());
		return hibernateTemplate;
	}
}
