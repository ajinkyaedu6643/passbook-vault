package com.passbookvault.service;

import java.util.List;

import com.passbookvault.entity.BankAccount;

public interface BankAccountService {
	
	BankAccount createAccount(BankAccount account);
	
	BankAccount getAccount(Long id);
	
	List<BankAccount> getAllAcounts();
	
	BankAccount updateAccount(Long id, BankAccount account);
	
	void deleteAccount(Long id);
}
