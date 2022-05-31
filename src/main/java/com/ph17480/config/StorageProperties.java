package com.ph17480.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties("storage")
@Data
public class StorageProperties {
	private String location;

}
