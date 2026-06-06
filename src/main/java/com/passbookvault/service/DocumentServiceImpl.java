package com.passbookvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.passbookvault.entity.BankAccount;
import com.passbookvault.entity.Document;
import com.passbookvault.exception.ResourceNotFoundException;
import com.passbookvault.repository.BankAccountRepository;
import com.passbookvault.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private BankAccountRepository accountRepository;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@Override
	public Document uploadDocument(Long accountId, MultipartFile file, String remarks) {
		// TODO Auto-generated method stub
		BankAccount account = 
				accountRepository.findById(accountId)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Account not found with id : "+ accountId));
		validateFile(file);
		
		String filePath = fileStorageService.storeFile(file, accountId);
		
		Document document = new Document();
		
		document.setBankaccount(account);
		document.setFileName(file.getOriginalFilename());
		document.setOriginalFileName(file.getOriginalFilename());
		document.setFileType(filePath);
		document.setFileSize(accountId);
		document.setFilePath(filePath);
		document.setRemark(remarks);
		
		return documentRepository.save(document);
	}
	
	private void validateFile(MultipartFile file) {
		if(file.isEmpty()) {
			throw new RuntimeException("File is empty");
		}
		
		String contentType = file.getContentType();
		
		if (contentType == null || 
				(!contentType.equals("application/pdf")
						&& !contentType.equals("image/jpeg")
						&& !contentType.equals("image/jpg")
						&& !contentType.equals("image/png"))) {
			throw new RuntimeException("Only PDF, JPG, JPEG, and PNG files are allowed");
		}
		
		if(file.getSize() >10*1024*1024) {
			throw new RuntimeException(
					"Maximum allowed file size is 10 MB");
		}
	}

}
