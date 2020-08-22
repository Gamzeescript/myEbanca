package com.ampersand.ebanca.utils;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class Configs {
	
/* Conexion */
	
	@Bean
	public DataSource getData() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mibanco?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");		
		return ds;
	}
	
	private Properties getPro() {
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return p;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getData());
		sf.setHibernateProperties(getPro());
		sf.setPackagesToScan("com.ampersand.ent.model");
		return sf;
	}
	
	@Bean
	public PlatformTransactionManager getTrans() {
		HibernateTransactionManager hib = new HibernateTransactionManager();
		hib.setSessionFactory(sessionFactory().getObject());
		return hib;
	}
	
	
	

}
