package com.aman.department_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.department_service.dto.DepartmentDto;
import com.aman.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
	{
		DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartmentDto,HttpStatus.OK);
	}
	
	@GetMapping("id/{deptid}")
	public ResponseEntity<DepartmentDto> findByIdDepartment(@PathVariable("deptid") Long id){
		DepartmentDto foundByIdDepartment = departmentService.findByIdDepartment(id);
		return new ResponseEntity<>(foundByIdDepartment,HttpStatus.OK);
	}
	
	@GetMapping("code/{deptCode}")
	public ResponseEntity<DepartmentDto> findByDeptCode(@PathVariable("deptCode") String depCode)
	{
		DepartmentDto foundViaDepartmentCodeDto = departmentService.findViaDepartmentCode(depCode);
		return ResponseEntity.ok(foundViaDepartmentCodeDto);
	}

}
