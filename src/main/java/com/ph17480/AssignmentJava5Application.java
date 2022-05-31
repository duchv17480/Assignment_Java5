package com.ph17480;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.ph17480.config.StorageProperties;
import com.ph17480.repositories.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AssignmentJava5Application {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentJava5Application.class, args);
	}
	@Bean
	CommandLineRunner init (StorageService storageService) {
		return (args->{
			storageService.init();
		});
	}

}
