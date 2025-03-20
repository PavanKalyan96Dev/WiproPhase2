package com.wipro;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableRabbit
@EnableFeignClients
public class SpringbootEmployeesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmployeesApplication.class, args);
    }

	/*
	 * @Bean public ModelMapper getModelMapper() { return new ModelMapper(); }
	 */

	
	  @Bean 
	  public WebClient webClient(WebClient.Builder builder) {
	        return builder
	                .baseUrl("http://localhost:8080")  // Replace with Department Service URL
	                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	                .build(); 
	  }
	 
}
