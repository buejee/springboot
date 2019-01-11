package com.xxx.springboot.config.upload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;

@Configuration
public class UploadConfig {
	@Bean(name="multipartResolver")
	public MultipartResolver multipartResolver() {
		return new CustomerMultipartResolver();
	}
}
