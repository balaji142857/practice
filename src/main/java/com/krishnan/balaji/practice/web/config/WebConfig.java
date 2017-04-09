package com.krishnan.balaji.practice.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.krishnan.balaji.practice.model.validation.EmployeeFormValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.krishnan.balaji.practice.web","com.krishnan.balaji.practice.model.validation" })
public class WebConfig extends WebMvcConfigurerAdapter {

	/*@Autowired
	LazyInitInterceptor osivInterceptor;*/
	@Autowired
	RoleFormatter roleFormatter;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor());
		//registry.addInterceptor(osivInterceptor);
	}

	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
		formatterRegistry.addFormatter(new DateFormatter("yyyyMMdd"));
		formatterRegistry.addFormatter(roleFormatter);
	}
	
	@Bean(name="employeeValidator")
	public EmployeeFormValidator validator(){
		return new EmployeeFormValidator();
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("message");
		return resource;
	}
	
}