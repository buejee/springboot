package com.xxx.springboot.config.web;

import org.springframework.context.annotation.Configuration;
@Configuration
public class WebAppConfig {
	/*
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	
	@PostConstruct
	public void initEditableValidation() {
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
		if(initializer.getConversionService()!=null) {
			GenericConversionService genericConversionService = new GenericConversionService();
			genericConversionService.addConverter(new String2DateConverter());
		}
	}*/
}
