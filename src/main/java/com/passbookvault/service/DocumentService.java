package com.passbookvault.service;

import org.springframework.web.multipart.MultipartFile;

import com.passbookvault.entity.Document;

public interface DocumentService {
	Document uploadDocument(
			Long accountId,
			MultipartFile file,
			String remarks);
	Document getDocumentById(Long id);
}
