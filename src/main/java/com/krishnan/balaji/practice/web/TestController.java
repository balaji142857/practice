package com.krishnan.balaji.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public @ResponseBody String test(){
		return "test successful";
	}
	
	@RequestMapping({"/testPage","/testpage"})
	public String testPage(){
		return "test";
	}
	
	@RequestMapping("/secured")
	public @ResponseBody String testSecurity(){
		return "security test successful";
	}
	
	@RequestMapping({"/securedPage","/securedpage"})
	public String testSecurityPage(){
		return "test";
	}

}
