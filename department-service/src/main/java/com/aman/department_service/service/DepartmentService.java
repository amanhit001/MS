package com.aman.department_service.service;

import com.aman.department_service.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto findByIdDepartment(Long id);
	DepartmentDto findViaDepartmentCode(String deptCode);
}
