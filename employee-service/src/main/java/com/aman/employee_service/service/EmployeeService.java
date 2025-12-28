package com.aman.employee_service.service;

import com.aman.employee_service.dto.APIResponseDto;
import com.aman.employee_service.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	APIResponseDto findEmployeeById(Long id);

}
