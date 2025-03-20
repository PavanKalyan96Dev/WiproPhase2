package com.wipro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.wipro")  
@EnableReactiveMongoRepositories(basePackages = "com.wipro.repository")
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApplication.class, args);
    }
}
