package com.passbookvault.dto;

public class DashboardSummaryDto {
	private long totalAccounts;
	private long activeAccounts;
	private long dormantAccounts;
	private long closedAccounts;
	private long savingAccounts;
	private long salaryAccounts;

	// Constructors
	public DashboardSummaryDto() {
	
		// TODO Auto-generated constructor stub
	}

	public DashboardSummaryDto(long totalAccounts, long activeAccounts, long dormantAccounts, long closedAccounts, long savingAccounts, long salaryAccounts) {

		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.dormantAccounts = dormantAccounts;
		this.closedAccounts = closedAccounts;
		this.savingAccounts = savingAccounts;
		this.salaryAccounts = salaryAccounts;
	}

	public long getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(long totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public long getActiveAccounts() {
		return activeAccounts;
	}

	public void setActiveAccounts(long activeAccounts) {
		this.activeAccounts = activeAccounts;
	}

	public long getDormantAccounts() {
		return dormantAccounts;
	}

	public void setDormantAccounts(long dormantAccounts) {
		this.dormantAccounts = dormantAccounts;
	}

	public long getClosedAccounts() {
		return closedAccounts;
	}

	public void setClosedAccounts(long closedAccounts) {
		this.closedAccounts = closedAccounts;
	}

	public long getSavingAccounts() {
		return savingAccounts;
	}

	public void setSavingAccounts(long savingAccounts) {
		this.savingAccounts = savingAccounts;
	}

	public long getSalaryAccounts() {
		return salaryAccounts;
	}

	public void setSalaryAccounts(long salaryAccounts) {
		this.salaryAccounts = salaryAccounts;
	}
	
	

	
}
