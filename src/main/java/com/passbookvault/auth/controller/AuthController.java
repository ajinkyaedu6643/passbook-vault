package com.passbookvault.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passbookvault.auth.dto.AuthResponse;
import com.passbookvault.auth.dto.LoginRequest;
import com.passbookvault.auth.dto.RegisterRequest;
import com.passbookvault.auth.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Access Management", description="API for Authentication and acces management")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(
			@RequestBody RegisterRequest reuqest){
		authService.register(reuqest);
		
		return ResponseEntity.ok("User Registred Successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(
	        @RequestBody LoginRequest request) {

	    String token =
	            authService.login(request);

	    return ResponseEntity.ok(
	            new AuthResponse(token));
	}
}
