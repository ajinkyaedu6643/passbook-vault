package com.passbookvault.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passbookvault.entity.BankAccount;
import com.passbookvault.service.BankAccountService;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
	
	private final BankAccountService service;
	
	public BankAccountController(BankAccountService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<BankAccount> createAccount(
			@RequestBody BankAccount account){
		return ResponseEntity.ok(
				service.createAccount(account));
	}
	
	@GetMapping
	public ResponseEntity<List<BankAccount>> getAllAcounts(){
		
		return ResponseEntity.ok(
				service.getAllAcounts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BankAccount> getAccountById(
			@PathVariable Long id){
		return ResponseEntity.ok(
				service.getAccount(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BankAccount> updateAccount(
			@PathVariable Long id,
			@RequestBody BankAccount account){
		return ResponseEntity.ok(
				service.updateAccount(id, account));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(
			@PathVariable Long id){
		service.deleteAccount(id);
		
		return ResponseEntity.ok(
				"Account deleted successfully");
	}
}
