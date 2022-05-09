package com.project.adminportal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    //registry.addResourceHandler("/imag/**").addResourceLocations("C:/Users/Fithawi/Desktop/adminportal/src/main/resources/static/imag/upload/");
	}
}
