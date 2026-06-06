package com.passbookvault.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageServiceImpl implements FileStorageService {
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@Override
	public String storeFile(MultipartFile file, Long accountId) {
		// TODO Auto-generated method stub
		try {
			Path accountFolder = Paths.get(uploadDir, "account-" + accountId);
			
			Files.createDirectories(accountFolder);
			
			String originalFileName = file.getOriginalFilename();
			
			String uniqueFileName = UUID.randomUUID()+"_"+originalFileName;
			
			Path targetLocation = accountFolder.resolve(uniqueFileName);
			
			Files.copy(
					file.getInputStream(),
					targetLocation);
			//file.transferTo(targetLocation.toFile());
		
			return targetLocation.toString();			
		}catch (IOException e) {
			throw new RuntimeException(
					"Failed to store file: "+ file.getOriginalFilename(),
					e);
		}
	}

}
