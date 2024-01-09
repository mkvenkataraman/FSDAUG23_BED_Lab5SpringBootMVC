package com.gl.empmgmt;

// Import necessary classes from the Spring Framework
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation to denote this class as a Spring Boot Application
@SpringBootApplication
public class EmployeeManagementApplication {

	// Main method - entry point of the application
	public static void main(String[] args) {
		// Running the Spring Application
		// This line sets up the entire Spring context and starts the Spring application
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
}
