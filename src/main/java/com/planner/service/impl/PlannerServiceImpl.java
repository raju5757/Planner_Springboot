package com.planner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.services.PlannerService;


@Service
public class PlannerServiceImpl implements PlannerService {
	@Autowired
	private PlannerService plannerService;
	
	
	@Override
	public Object getUsers() {
		return plannerService.getUsers();
	}
}
