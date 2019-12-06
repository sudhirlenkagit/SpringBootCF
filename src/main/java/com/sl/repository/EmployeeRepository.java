package com.sl.repository;

import org.springframework.data.repository.CrudRepository;

import com.sl.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
}