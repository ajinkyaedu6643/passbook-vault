package com.passbookvault.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bank_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Bank name is required")
	private String bankName;
	
	@NotBlank(message = "Account holder name is required")
	private String accountHolderName;
	
	@NotBlank(message = "Account Number is required")
	private String accountNumber;
	
	@NotBlank(message = "IFSC code is required")
	private String ifscCode;
	
	private String branchName;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	
	private String nomineeName;
	
	private String nomineeRelation;
	
	private String mobileNumber;
	
	private String email;
	
	@Column(length = 2000)
	private String notes;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
		
		if (accountStatus == null) {
			accountStatus = AccountStatus.ACTIVE;
		}
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
	}
	
}
