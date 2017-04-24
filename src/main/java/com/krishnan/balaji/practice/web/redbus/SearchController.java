package com.krishnan.balaji.practice.web.redbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.krishnan.balaji.practice.service.redbus.SearchingService;

@Controller
public class SearchController {

	@Autowired SearchingService service;
	
	public ModelAndView serveSearchPage(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
