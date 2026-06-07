package com.passbookvault.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
		
		@Bean
		public OpenAPI passbookVaultOpenAPI() {
			return new OpenAPI()
					.info(new Info()
							.title("Passbook Vault API")
							.description("Bank account and document Management System")
							.version("v0.3.0")
							.contact(new Contact()
									.name("Ajinkya Gaikwad")
									.email("ajinkya.learn01@gmail.com")
									.url("https://github.com/ajinkyaedu6643/passbook-vault")));
		}
}
