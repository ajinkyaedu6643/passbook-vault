package com.passbookvault.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	String storeFile(MultipartFile file, Long accountId);
}
