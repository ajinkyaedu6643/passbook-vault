package com.passbookvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.passbookvault.entity.Document;
import com.passbookvault.service.DocumentService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Document> uploadDocument(
			@RequestParam Long accountId,
			@RequestParam MultipartFile file,
			@RequestParam(required = false) String remarks){
		Document document = documentService.uploadDocument(accountId, file, remarks);
		
		return ResponseEntity.ok(document);
	}
}
