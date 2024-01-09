package com.gl.empmgmt.controller;

// Importing necessary classes
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.empmgmt.entity.Employee;
import com.gl.empmgmt.service.EmployeeServiceImpl;

// Annotation to denote this class as a Controller in a Spring MVC application
@Controller
// Mapping requests that start with '/employee'
@RequestMapping("/employee")
public class EmployeeController {
	// Declaration of the EmployeeService
	private EmployeeServiceImpl employeeService;

	// Constructor to autowire the EmployeeService implementation
	@Autowired
	public EmployeeController(EmployeeServiceImpl employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// Method to handle GET requests for "/employee/list"
	@GetMapping("/list")
	public String findAllEmployees(Model model) {
		// Fetching all employees from the service
		List<Employee> employees = employeeService.findAll();
		// Adding the list of employees to the model to be used in the view
		model.addAttribute("employees", employees);
		// Returning the view name to be rendered
		return "employee-list";
	}

	// Method to handle GET requests for "/employee/addEmployee"
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		// Creating a new empty Employee object
		Employee employee = new Employee();
		// Adding the empty Employee to the model for binding form data
		model.addAttribute("employee", employee);
		return "employee-add";
	}

	// Method to handle GET requests for "/employee/updateEmployee/{id}"
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(Model model, @PathVariable int id) {
		// Fetching the Employee by ID
		Employee employee = employeeService.findById(id);
		// Adding the fetched Employee to the model
		model.addAttribute("employee", employee);
		return "employee-edit";
	}

	// Method to handle GET requests for "/employee/delete/{id}"
	@GetMapping("/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable int id) {
		// Deleting the Employee by ID
		employeeService.deleteById(id);
		// Redirecting to the list of employees
		return "redirect:/employee/list";
	}

	// Method to handle POST requests for "/employee/saveEmployee"
	@PostMapping("/saveEmployee")
	public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee) {
		// Saving or updating the Employee
		employeeService.saveOrUpdate(employee);
		// Redirecting to the list of employees
		return "redirect:/employee/list";
	}
}
