package com.wipro;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class SpringbootDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDepartmentApplication.class, args);
	}
	
	@Bean
	public  ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
