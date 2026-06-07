package com.passbookvault.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http) throws Exception{
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(
							"/api/auth/**",
							"/swagger-ui/**",
							"/swagger-ui.html",
							"/v3/api-docs/**")
					.permitAll()
					.anyRequest()
					.authenticated())
			.exceptionHandling(exception ->
		    exception.authenticationEntryPoint(
		            (request, response, authException) ->
		                response.sendError(
		                    HttpServletResponse.SC_UNAUTHORIZED,
		                    "Unauthorized")));
		http.addFilterBefore(
		        jwtAuthenticationFilter,
		        UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
