package com.aman.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.department_service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
