package com.rest_db.crudrestdb.service;

import com.rest_db.crudrestdb.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    Employee deleteById(int theId);
}
