package com.gl.empmgmt.dao;

// Importing necessary classes
import java.util.List;

import com.gl.empmgmt.entity.Employee;

// Interface for Employee Data Access Object (DAO)
// This interface defines the standard operations to be performed on Employee entities
public interface EmployeeDao {

	// Method to retrieve all Employee records from the database
	// Returns a List of Employee objects
	public List<Employee> findAll();

	// Method to find a specific Employee by their ID
	// Takes an integer id as a parameter and returns the corresponding Employee
	// object
	public Employee findById(int id);

	// Method to save or update an Employee record in the database
	// Accepts an Employee object as a parameter
	// The method can handle both insertion and update operations based on the state
	// of the Employee object
	public void saveOrUpdate(Employee employee);

	// Method to delete an Employee record from the database by their ID
	// Takes an integer id as a parameter
	// It removes the Employee record corresponding to the provided id
	public void deleteById(int id); // Note: There's a typo here, it should be 'deleteById' not 'delteById'
}
