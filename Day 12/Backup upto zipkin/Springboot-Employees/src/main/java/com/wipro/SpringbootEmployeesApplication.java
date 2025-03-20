package com.wipro;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

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

	/*
	 * @Bean public WebClient webClient() { return WebClient.builder().build(); }
	 */
}
