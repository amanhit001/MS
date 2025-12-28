package com.aman.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aman.employee_service.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8093/department/")
public interface ApiClient {
	@GetMapping("code/{deptCode}")
	DepartmentDto findByDeptCode(@PathVariable("deptCode") String depCode);
	
}
