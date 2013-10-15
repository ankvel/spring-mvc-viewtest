package com.akestrel.edu.dao;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;



@Configuration
@PropertySource("classpath:jdbc.properties")
public class CustomDaoConfig implements DaoConfig {
	
	@Autowired
    Environment env;


	
	
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}

	
	@Bean(initMethod="init", destroyMethod="close")	
	public AtomikosDataSourceBean dataSource1() {

		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		ds.setUniqueResourceName("EIS1DBMS");
		ds.setXaDataSourceClassName(env.getProperty("jdbc.postgres.driverClassName"));
		Properties props = new Properties();
		props.setProperty("serverName",  env.getProperty("jdbc.postgres.serverName"));
		props.setProperty("portNumber", env.getProperty("jdbc.postgres.portNumber"));
		props.setProperty("databaseName", env.getProperty("jdbc.postgres.databaseName"));
		props.setProperty("user", env.getProperty("jdbc.postgres.username"));
		props.setProperty("password", env.getProperty("jdbc.postgres.password"));		
		ds.setXaProperties(props);
		ds.setTestQuery(env.getProperty("jdbc.postgres.testQuery"));
		return ds;
	}
	
	@Bean(initMethod="init", destroyMethod="close")	
	UserTransactionManager jtaTransactionManager() {
		return new UserTransactionManager();
	}
	
	
	/*@Bean(initMethod="init", destroyMethod="close")	
	UserTransactionImp jtaUserTransaction() {
		return new UserTransactionManager();
	}*/
	
	
	@Bean	
	JtaTransactionManager transactionManager() {
		JtaTransactionManager tm = new JtaTransactionManager();
		tm.setTransactionManager(jtaTransactionManager());
		//tm.setUserTransaction(jtaUserTransaction())
		return tm;
	}

	
	@Bean
	public AksMessageDao aksMessageDao() {			
		AksMessageDao amd = new AksMessageDaoJdbc(dataSource1());
		return amd;
	}	
}
