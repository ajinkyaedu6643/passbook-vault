package com.passbookvault.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.passbookvault.entity.Document;
import com.passbookvault.exception.ResourceNotFoundException;
import com.passbookvault.service.DocumentService;

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
	
	@GetMapping("/{id}/download")
	ResponseEntity<FileSystemResource> downloadDocument(
			@PathVariable Long id) throws Exception{
		Document document = documentService.getDocumentById(id);
		
		File file = new File(document.getFilePath());
		
		if(!file.exists()) {
			throw new ResourceNotFoundException("File not found on disk");
		}
		
		FileSystemResource resource = new FileSystemResource(file);
		
		String contentType = Files.probeContentType(file.toPath());
		
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName()+"\"")
				.body(resource);
	}
}
