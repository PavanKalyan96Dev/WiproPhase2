package com.wipro.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class StartupRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started with CommandLineRunner");

		for (String arg : args) {
		    System.out.println("Argument: " + arg);
		}

	}

}
