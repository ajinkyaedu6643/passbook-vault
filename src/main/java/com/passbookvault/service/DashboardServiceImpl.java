package com.passbookvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passbookvault.dto.DashboardSummaryDto;
import com.passbookvault.entity.AccountStatus;
import com.passbookvault.entity.AccountType;
import com.passbookvault.repository.BankAccountRepository;

@Service
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	private BankAccountRepository repository;

	@Override
	public DashboardSummaryDto getSummary() {
		// TODO Auto-generated method stub
		long total = repository.count();
		long active = repository.countByAccountStatus(AccountStatus.ACTIVE);
		long dormant = repository.countByAccountStatus(AccountStatus.DORMANT);
		long closed = repository.countByAccountStatus(AccountStatus.CLOSED);
		long saving = repository.countByAccountType(AccountType.SAVINGS);
		long salary = repository.countByAccountType(AccountType.SALARY);
		return new DashboardSummaryDto(total, active, dormant, closed, saving, salary);
	}

}
