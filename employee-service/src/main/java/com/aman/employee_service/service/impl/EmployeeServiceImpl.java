package com.aman.employee_service.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aman.employee_service.dto.APIResponseDto;
import com.aman.employee_service.dto.DepartmentDto;
import com.aman.employee_service.dto.EmployeeDto;
import com.aman.employee_service.entity.Employee;
import com.aman.employee_service.mapper.EmployeeMapper;
import com.aman.employee_service.repository.EmployeeRepository;
import com.aman.employee_service.service.EmployeeService;

import jakarta.persistence.CacheRetrieveMode;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepo;
	
	//private RestTemplate restTemplate;
	WebClient webClient;
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee mappedEmployee = EmployeeMapper.mapToEmployee(employeeDto);
		if (mappedEmployee.getAddresses() != null) {
			mappedEmployee.getAddresses().forEach(address ->
	            address.setEmployee(mappedEmployee)
	        );
	    }
		Employee savedEmployee = employeeRepo.save(mappedEmployee);
		EmployeeDto mappedSavedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return mappedSavedEmployeeDto;
	
	}

	@Override
	public APIResponseDto findEmployeeById(Long id) {
		Optional<Employee> findById = employeeRepo.findById(id);
		Employee foundEmployee = findById.get();
		
		//Now get the Department detail via RestTemplate
//		ResponseEntity<DepartmentDto> responsefoundDepartmentDto = restTemplate.getForEntity("http://localhost:8093/department/code/"+foundEmployee.getDepartmentCode(),  DepartmentDto.class);
//		DepartmentDto foundDepartmentDto = responsefoundDepartmentDto.getBody();
		
		DepartmentDto foundDepartmentDto = webClient.get()
		.uri("http://localhost:8093/department/code/"+foundEmployee.getDepartmentCode())
			.retrieve().bodyToMono(DepartmentDto.class).block();
		EmployeeDto mappedEmployeeDto = EmployeeMapper.mapToEmployeeDto(foundEmployee);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartment(foundDepartmentDto);
		apiResponseDto.setEmployee(mappedEmployeeDto);
		return apiResponseDto;
		
	}

}
