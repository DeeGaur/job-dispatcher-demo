package com.jobdispatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.jobdispatcher")
public class JobdispatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobdispatcherApplication.class, args);
	}

}
