package com.sl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.models.Employee;
import com.sl.services.EmployeeService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String home() {
		return "Hello Microservices!";
	}

	@RequestMapping("/employee/count")
	public long count() {
		log.info("Search total number of employees");
		return employeeService.getCount();
	}

	@RequestMapping("/employee/all")
	public List<Employee> getAllEmployees() {
		log.info("Searching all employees");
		return employeeService.findAllEmployee();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee/add")
	public boolean addEmployee(@RequestBody Employee employee) {

		log.info("Creation/Updating Employee - " + employee.toString());
		return employeeService.insertEmployee(employee);
	}

	@RequestMapping("/employee/id/{id}")
	public Employee findById(@PathVariable String id) {
		log.info("Searching employee with ID - " + id);
		return employeeService.findEmployeeById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/delete/{id}")
	public boolean deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}

}