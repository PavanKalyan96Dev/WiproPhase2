package com.wipro.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.wipro")

public class Myconfig
{

		@Bean
	 	public DataSource dataSource() {
	     	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	     	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	     	dataSource.setUrl("jdbc:mysql://localhost:3306/wipro");
	     	dataSource.setUsername("root");
	     	dataSource.setPassword("#Mahadev7");
	     	return dataSource;
	 	}
	 
		@Bean
	 	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	     	return new JdbcTemplate(dataSource);
	 	}


}
