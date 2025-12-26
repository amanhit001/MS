package com.aman.department_service.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aman.department_service.dto.DepartmentDto;
import com.aman.department_service.entity.Department;
import com.aman.department_service.mapper.DepartmentMapper;
import com.aman.department_service.repository.DepartmentRepository;
import com.aman.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	DepartmentRepository departmentRepo;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department mappedDepartment = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepo.save(mappedDepartment);
		DepartmentDto mappedSavedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
		return mappedSavedDepartmentDto;
		
	}

	@Override
	public DepartmentDto findByIdDepartment(Long id) {
		Optional<Department> findById = departmentRepo.findById(id);
		Department foundDepartment = findById
		        .orElseThrow(() -> new RuntimeException(
		                "No department found with this id " + id +"\n"));

		//Department foundDepartment = findById.get().orElseThrow(() -> new RuntimeException("No deparment found with this "+id));
		DepartmentDto mappedSavedDepartmentDto = DepartmentMapper.mapToDepartmentDto(foundDepartment);
		return mappedSavedDepartmentDto;
	}

}
