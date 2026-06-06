package com.passbookvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passbookvault.dto.DashboardSummaryDto;
import com.passbookvault.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService service;
	
	@GetMapping("/summary")
	public ResponseEntity<DashboardSummaryDto> getSummary(){
		return ResponseEntity.ok(
				service.getSummary());
	}
}
