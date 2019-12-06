package com.sl.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sl.models.Employee;
import com.sl.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public long getCount() {
		long count = employeeRepository.count();
		return count;
	}

	public List<Employee> findAllEmployee() {
		List<Employee> employee = new ArrayList<>();
		employeeRepository.findAll().forEach(employee::add);
		return employee;
	}

	public boolean insertEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Employee findEmployeeById(String id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		return employee;
	}

	public boolean deleteEmployee(String id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee != null) {
			employeeRepository.delete(employee);
			return true;
		}
		return false;
	}
}