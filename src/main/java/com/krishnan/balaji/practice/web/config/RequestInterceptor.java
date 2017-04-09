package com.krishnan.balaji.practice.web.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1,
			Object arg2) throws Exception {
		Map<String,String[]> params = req.getParameterMap();
		System.out.println("<<<<<<<<<Intercepting "+req.getMethod()+"\t"+req.getRequestURL()+">>>>>>>>");
		String dateFolder=DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.now());
		String fileName = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.now());
		System.out.println(dateFolder+"_T_"+fileName);
		System.err.println("===params====");
		params.forEach((k,v) -> {
			System.out.print(k+" ");
			Arrays.stream(v).forEach(System.out::println);
			System.out.println();
		});
	System.out.println("===headers===");
	 Enumeration<String> headers  = req.getHeaderNames();
	 while(headers.hasMoreElements()){
		 String header = headers.nextElement();
		 System.out.println(header + " : " +req.getHeader(header));
	 }
	return true	;
	}

}
