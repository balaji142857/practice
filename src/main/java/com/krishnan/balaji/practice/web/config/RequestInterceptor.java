package com.krishnan.balaji.practice.web.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2) throws Exception {
		Map<String, String[]> params = req.getParameterMap();
		log.info("<<<<<<<<<Intercepting " + req.getMethod() + "\t" + req.getRequestURL() + ">>>>>>>>");
		log.info(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
		log.info("===params====");
		params.forEach((k, v) -> {
			log.info(k + " ");
			Arrays.stream(v).forEach(log::info);
			log.info("\n");
		});
		log.info("===headers===");
		Enumeration<String> headers = req.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			log.info(header + " : " + req.getHeader(header));
		}
		return true;
	}
}