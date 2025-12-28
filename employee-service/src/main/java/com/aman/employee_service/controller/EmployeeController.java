package com.aman.employee_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.employee_service.dto.APIResponseDto;
import com.aman.employee_service.dto.EmployeeDto;
import com.aman.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
	
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
	}
	
	@GetMapping("{eid}")
	public ResponseEntity<APIResponseDto> findEmployeeById(@PathVariable("eid") Long id){
		APIResponseDto findEmployeeById = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(findEmployeeById,HttpStatus.OK);
	}
	

}
