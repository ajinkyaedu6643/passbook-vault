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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.passbookvault.entity.AccountStatus;
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
	
	//Search and filter Module
	
	@GetMapping("/search/bank")
	public ResponseEntity<List<BankAccount>> searchBank(
			@RequestParam String name){
		return ResponseEntity.ok(service.searchByBankName(name));
	}
	
	@GetMapping("/search/holder")
	public ResponseEntity<List<BankAccount>> searchByHolder(
			@RequestParam String holderName){
		return ResponseEntity.ok(
				service.searchByHolderName(holderName));
	}
	
	@GetMapping("/search/ifsc")
	public ResponseEntity<List<BankAccount>> searchByIfsc(
			@RequestParam String ifsc){
		return ResponseEntity.ok(
				service.searchByIfsc(ifsc));
	}
	
	@GetMapping("/search/accountStatus")
	public ResponseEntity<List<BankAccount>> searchByStatus(
			@RequestParam AccountStatus accountStatus){
		
		return ResponseEntity.ok(
				service.serachByStatus(accountStatus));
	}
	
	@GetMapping("/search/keyword")
	public ResponseEntity<List<BankAccount>> searchByKeyword(
			@RequestParam  String keyword){
		return ResponseEntity.ok(
				service.serachByKeyword(keyword));
	}
	
	
	
}
