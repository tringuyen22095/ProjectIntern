package com.intern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.intern")
public class ProjectInternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectInternApplication.class, args);
	}
}
