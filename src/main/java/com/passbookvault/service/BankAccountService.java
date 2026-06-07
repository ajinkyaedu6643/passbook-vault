package com.passbookvault.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.passbookvault.entity.AccountStatus;
import com.passbookvault.entity.BankAccount;

public interface BankAccountService {
	
	BankAccount createAccount(BankAccount account);
	
	BankAccount getAccount(Long id);
	
	Page<BankAccount> getAllAcounts(
			int page,
			int size,
			String sortBy,
			String sortDir);
	List<BankAccount> getAccounts();
	
	BankAccount updateAccount(Long id, BankAccount account);
	
	void deleteAccount(Long id);
	
	List<BankAccount> searchByBankName(String bankName);
	List<BankAccount> searchByHolderName(String holderName);
	List<BankAccount> searchByIfsc(String ifsc);
	List<BankAccount> serachByStatus(AccountStatus status);
	List<BankAccount> serachByKeyword(String keyword);
}
