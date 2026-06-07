package com.passbookvault.auth.service;

import com.passbookvault.auth.dto.LoginRequest;
import com.passbookvault.auth.dto.RegisterRequest;

public interface AuthService {
	void register(RegisterRequest request);
	String login(LoginRequest request);
}
