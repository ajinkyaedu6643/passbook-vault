package com.passbookvault.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.passbookvault.auth.Role;
import com.passbookvault.auth.User;
import com.passbookvault.auth.dto.LoginRequest;
import com.passbookvault.auth.dto.RegisterRequest;
import com.passbookvault.repository.UserRepository;
import com.passbookvault.security.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public void register(RegisterRequest request) {
		// TODO Auto-generated method stub
		if(userRepository.existsByUsername(request.getUsername())) {
			throw new RuntimeException("Username Alreday exits");
		}
		
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		
		User user = new User();
		
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.USER);
		
		userRepository.save(user);
		
		
	}

	@Override
	public String login(LoginRequest request) {
		User user =
	            userRepository.findByUsername(
	                    request.getUsername())
	                    .orElseThrow(
	                            () -> new RuntimeException(
	                                    "Invalid username or password"));

	    if (!passwordEncoder.matches(
	            request.getPassword(),
	            user.getPassword())) {

	        throw new RuntimeException(
	                "Invalid username or password");
	    }

	    return jwtUtil.generateToken(
	            user.getUsername());
	}

}
