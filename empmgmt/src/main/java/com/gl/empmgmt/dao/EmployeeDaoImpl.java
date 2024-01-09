package com.gl.empmgmt.dao;

// Importing necessary classes
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.empmgmt.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

// Annotation to denote this class as a Repository in the Spring context
// This indicates that it's a Data Access Object (DAO)
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	// EntityManager is the JPA interface for accessing the persistence context
	EntityManager entityManager;

	// Constructor with Autowired annotation to automatically inject the
	// EntityManager instance
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	// Method to find all Employee records
	// Transactional annotation denotes that this method should be run within a
	// transaction
	@Override
	@Transactional
	public List<Employee> findAll() {
		// Unwrapping the JPA EntityManager to get the native Hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);
		// Creating a Hibernate Query to fetch all Employee entities
		Query query = currentSession.createQuery("from Employee");
		// Executing the query and retrieving the result list
		List<Employee> employees = query.getResultList();
		return employees;
	}

	// Method to find a specific Employee by their ID
	@Override
	@Transactional
	public Employee findById(int id) {
		// Unwrapping the EntityManager to get the Hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);
		// Retrieving the Employee entity by its ID
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	// Method to save or update an Employee record
	@Override
	@Transactional
	public void saveOrUpdate(Employee employee) {
		// Unwrapping to get the Session
		Session currentSession = entityManager.unwrap(Session.class);
		// Saving or updating the Employee entity
		currentSession.saveOrUpdate(employee);
	}

	// Method to delete an Employee record by ID
	@Override
	@Transactional
	public void deleteById(int id) {
		// Unwrapping to get the Session
		Session currentSession = entityManager.unwrap(Session.class);
		// Finding the Employee to be deleted
		Employee employee = findById(id);
		// Deleting the found Employee
		currentSession.delete(employee);
	}
}
