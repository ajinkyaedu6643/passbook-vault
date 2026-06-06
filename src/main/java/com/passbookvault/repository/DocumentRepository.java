package com.passbookvault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passbookvault.entity.Document;

public interface DocumentRepository  extends JpaRepository<Document, Long>{
	List<Document> findByBankAccountId(Long accountId);
}
