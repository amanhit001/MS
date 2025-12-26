package com.aman.employee_service.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.employee_service.dto.EmployeeDto;
import com.aman.employee_service.entity.Employee;
import com.aman.employee_service.mapper.EmployeeMapper;
import com.aman.employee_service.repository.EmployeeRepository;
import com.aman.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee mappedEmployee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepo.save(mappedEmployee);
		EmployeeDto mappedSavedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return mappedSavedEmployeeDto;
	
	}

	@Override
	public EmployeeDto findEmployeeById(Long id) {
		Optional<Employee> findById = employeeRepo.findById(id);
		Employee foundEmployee = findById.get();
		EmployeeDto mappedEmployeeDto = EmployeeMapper.mapToEmployeeDto(foundEmployee);
		return mappedEmployeeDto;
		
	}

}
