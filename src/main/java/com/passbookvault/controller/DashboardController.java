package com.passbookvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passbookvault.dto.DashboardSummaryDto;
import com.passbookvault.service.DashboardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
	    name = "Dashboard",
	    description = "Dashboard and reporting APIs"
	)
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService service;
	
	@Operation(
		    summary = "Dashboard summary",
		    description = "Returns summary statistics such as total accounts and documents"
		)
	@GetMapping("/summary")
	public ResponseEntity<DashboardSummaryDto> getSummary(){
		return ResponseEntity.ok(
				service.getSummary());
	}
}
