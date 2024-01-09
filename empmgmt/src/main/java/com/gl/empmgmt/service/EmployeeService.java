package com.gl.empmgmt.service;

// Importing necessary classes
import java.util.List;

import com.gl.empmgmt.entity.Employee;

// Interface for Employee Service
// This interface defines the business logic operations for Employee entities
public interface EmployeeService {

	// Method to retrieve all Employee records
	// Returns a List of Employee objects
	// This method is intended to handle the logic for fetching all employees from
	// the data source
	public List<Employee> findAll();

	// Method to find a specific Employee by their ID
	// Takes an integer id as a parameter and returns the corresponding Employee
	// object
	// This method encapsulates the logic for fetching a single employee based on
	// their unique identifier
	public Employee findById(int id);

	// Method to save or update an Employee record
	// Accepts an Employee object as a parameter
	// This method can handle both saving a new Employee and updating an existing
	// Employee
	// The differentiation between save and update is typically determined by the
	// state of the Employee object (e.g., whether it has an ID or not)
	public void saveOrUpdate(Employee employee);

	// Method to delete an Employee record by their ID
	// Takes an integer id as a parameter
	// This method encapsulates the logic to remove an Employee from the data source
	// based on their ID
	public void deleteById(int id);
}
