package com.ph17480.repositories.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ph17480.config.StorageProperties;
import com.ph17480.exception.StorageException;
import com.ph17480.repositories.StorageService;
@Service
public class FileSystemStorage implements StorageService{
	private final Path rootlocation;
	@Override
	public String getStoredFileName(MultipartFile file, String id) {
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		return "p"+id+"."+ext;
	}
	public FileSystemStorage(StorageProperties properties) {
		this.rootlocation=Paths.get(properties.getLocation());
	}
	@Override
	public void store (MultipartFile file , String storedFileName) {
		try {
			if (!file.isEmpty()) {
				throw new StorageException("File to store empty file");
			}
			Path destinationFile = this.rootlocation.resolve(Paths.get(storedFileName))
					.normalize().toAbsolutePath();
			if (!destinationFile.getParent().equals(this.rootlocation.toAbsolutePath())) {
				throw new StorageException("cannot store file outside current directory");
			}
			try {
				InputStream inputStream = file.getInputStream();
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
			}
		} catch (Exception e) {
			throw new StorageException("Failed t store file"+e);
		}
	}
	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists()|| resource.isReadable()) {
				return resource;
			}
			throw new StorageException("could not read file"+filename);
		} catch (Exception e) {
			throw new StorageException("could not read file"+filename);
		}
		
	}
	@Override
	public Path load (String filename) {
		return rootlocation.resolve(filename);
	}
	@Override
	public void delete (String storedFilename) throws IOException {
		Path destinationFile = rootlocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
		Files.delete(destinationFile);
	}
	@Override
	public void init() {
		try {
			Files.createDirectories(rootlocation);
			System.out.println(rootlocation.toString());
		} catch (Exception e) {
			throw new StorageException("could not init",e);
		}
	}
}
