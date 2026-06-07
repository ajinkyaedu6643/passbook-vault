package com.passbookvault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.passbookvault.entity.AccountStatus;
import com.passbookvault.entity.AccountType;
import com.passbookvault.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
	List<BankAccount> findByBankName(String bankName);
	List<BankAccount> findByAccountHolderName(String accountHolderName);
	List<BankAccount> findByIfscCode(String ifscCode);
	List<BankAccount> findByAccountStatus(AccountStatus accountStatus);
	long countByAccountStatus(AccountStatus accountStatus);
	long countByAccountType(AccountType accountType);
	List<BankAccount> findByBankNameContainingIgnoreCase(String bankName);
	List<BankAccount> findByAccountHolderNameContainingIgnoreCase(String accountHolderName);
	
	
//	List<BankAccount> findByBankNameContainingIgnoreCaseOrAccountHolderNameContainingIgnoreCaseOrIfscContainingIgnoreCase(
//			String name, String accountHolderName,String ifsc);
	@Query("""
			SELECT b FROM BankAccount b
			WHERE LOWER(b.bankName) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(b.accountHolderName) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(b.ifscCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
			""")
	List<BankAccount> searchByKeyword(@Param("keyword") String keyword);
}
