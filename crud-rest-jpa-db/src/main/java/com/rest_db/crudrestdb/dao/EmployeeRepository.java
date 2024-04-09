package com.rest_db.crudrestdb.dao;

import com.rest_db.crudrestdb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
