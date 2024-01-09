package com.gl.empmgmt.service;

// Importing necessary classes and interfaces
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.empmgmt.dao.EmployeeDao;
import com.gl.empmgmt.entity.Employee;

// Annotation to denote this class as a Service in the Spring context
// This indicates that it's part of the Service layer handling business logic
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Reference to the EmployeeDao interface
	EmployeeDao employeeDao;

	// Constructor with Autowired annotation to automatically inject the EmployeeDao
	// implementation
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	// Method to find all Employee records
	// It delegates the call to the EmployeeDao's findAll method
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	// Method to find a specific Employee by their ID
	// It delegates the call to the EmployeeDao's findById method
	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	// Method to save or update an Employee record
	// It delegates the call to the EmployeeDao's saveOrUpdate method
	@Override
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	// Method to delete an Employee record by ID
	// It delegates the call to the EmployeeDao's deleteById method
	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}
}
