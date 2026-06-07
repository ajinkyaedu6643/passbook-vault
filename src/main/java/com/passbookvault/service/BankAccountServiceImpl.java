package com.passbookvault.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.passbookvault.entity.AccountStatus;
import com.passbookvault.entity.BankAccount;
import com.passbookvault.exception.ResourceNotFoundException;
import com.passbookvault.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	private final BankAccountRepository repository;
	
	public BankAccountServiceImpl(BankAccountRepository repository) {
		this.repository = repository;
	}
	@Override
	public BankAccount createAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return repository.save(account);
	}

	@Override
	public BankAccount getAccount(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Account not found with id: "+id));
	}

	@Override
	public Page<BankAccount> getAllAcounts(
			int page,
			int size,
			String sortBy,
			String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase("desc")
				? Sort.by(sortBy).descending()
				: Sort.by(sortBy).ascending();
		
		Pageable pageable = 
				PageRequest.of(page, size, sort);
		return repository.findAll(pageable);
	}

	@Override
	public BankAccount updateAccount(Long id, BankAccount account) {
		// TODO Auto-generated method stub
		BankAccount existing = getAccount(id);
		
		existing.setBankName(account.getBankName());
		existing.setAccountHolderName(account.getAccountHolderName());
		existing.setAccountNumber(account.getAccountNumber());
		existing.setIfscCode(account.getIfscCode());
		existing.setBranchName(account.getBranchName());
		existing.setAccountType(account.getAccountType());
		existing.setAccountStatus(account.getAccountStatus());
		existing.setNomineeName(account.getNomineeName());
		existing.setNomineeRelation(account.getNomineeRelation());
		existing.setMobileNumber(account.getMobileNumber());
		existing.setEmail(account.getEmail());
		existing.setNotes(account.getNotes());
		
		return repository.save(existing);
		
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}
	@Override
	public List<BankAccount> searchByBankName(String bankName) {
		// TODO Auto-generated method stub
		return repository.findByBankNameContainingIgnoreCase(bankName);
	}
	@Override
	public List<BankAccount> searchByHolderName(String holderName) {
		// TODO Auto-generated method stub
		return repository.findByAccountHolderNameContainingIgnoreCase(holderName);
	}
	@Override
	public List<BankAccount> searchByIfsc(String ifsc) {
		// TODO Auto-generated method stub
		return repository.findByIfscCode(ifsc);
	}
	@Override
	public List<BankAccount> serachByStatus(AccountStatus status) {
		// TODO Auto-generated method stub
		return repository.findByAccountStatus(status);
	}
	@Override
	public List<BankAccount> serachByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return repository.searchByKeyword(keyword);
	}
	@Override
	public List<BankAccount> getAccounts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
