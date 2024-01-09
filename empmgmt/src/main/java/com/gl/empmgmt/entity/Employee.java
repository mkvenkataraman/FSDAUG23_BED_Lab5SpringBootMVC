package com.gl.empmgmt.entity;

// Importing JPA (Jakarta Persistence API) annotations
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Annotation to mark this class as a JPA entity
@Entity
public class Employee {

	// Annotation to mark 'id' as the primary key of this entity
	@Id
	// Annotation to specify that 'id' should be generated automatically
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Annotation to map 'firstName' to the column named 'emp_fname' in the database
	@Column(name = "emp_fname")
	private String firstName;

	// Annotation to map 'lastName' to the column named 'emp_lname' in the database
	@Column(name = "emp_lname")
	private String lastName;

	// Annotation to map 'email' to the column named 'emp_email' in the database
	@Column(name = "emp_email")
	private String email;

	// Standard getter method for 'id'
	public int getId() {
		return id;
	}

	// Standard setter method for 'id'
	public void setId(int id) {
		this.id = id;
	}

	// Standard getter method for 'firstName'
	public String getFirstName() {
		return firstName;
	}

	// Standard setter method for 'firstName'
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Standard getter method for 'lastName'
	public String getLastName() {
		return lastName;
	}

	// Standard setter method for 'lastName'
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Standard getter method for 'email'
	public String getEmail() {
		return email;
	}

	// Standard setter method for 'email'
	public void setEmail(String email) {
		this.email = email;
	}

	// Constructor with fields
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// Default no-arg constructor
	public Employee() {
		super();
	}

	// Overridden 'toString' method for printing Employee details
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
