package com.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planner.services.PlannerService;



@RestController
@CrossOrigin
public class PlannerController {

	
	@Autowired
	private PlannerService plannerService;
	
	@GetMapping("/api/planner/getusers")
	public Object getUsers() {
		return this.plannerService.getUsers();
	}
}
