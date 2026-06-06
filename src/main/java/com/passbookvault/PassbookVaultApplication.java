package com.passbookvault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.passbookvault.repository.BankAccountRepository;

@SpringBootApplication
public class PassbookVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassbookVaultApplication.class, args);
		
	}

}
