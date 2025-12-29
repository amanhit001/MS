package com.aman.department_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
//The above scope is used for automatically restart the application if the properties are changed
//you need to add management.endpoints.web.exposure.include=* 
//basically enable all the actuator 
@RestController
public class MessageRefreshController {
	
	@Value("${spring.message}")
	private String message;
	
	@GetMapping("mymsg")
	public String getMessage()
	{
		return "hello " + message;
	}

}
