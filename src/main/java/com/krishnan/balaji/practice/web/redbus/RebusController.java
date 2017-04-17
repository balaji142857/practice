package com.krishnan.balaji.practice.web.redbus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RebusController {
	
	@GetMapping("/redbus/links/")
	public String get(){
		return "/redbus/links";
	}

}
