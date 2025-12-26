package com.aman.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
