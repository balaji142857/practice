package com.krishnan.balaji.practice.config;

import javax.servlet.ServletContext;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer{

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		insertFilters(servletContext, new MultipartFilter());
	}

	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		super.afterSpringSecurityFilterChain(servletContext);
		insertFilters(servletContext, new OpenEntityManagerInViewFilter());
	}
	
	
}
