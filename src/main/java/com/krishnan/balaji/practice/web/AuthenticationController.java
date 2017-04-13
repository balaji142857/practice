package com.krishnan.balaji.practice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.krishnan.balaji.practice.service.RoleService;
import com.krishnan.balaji.practice.service.UserInfoService;

@Controller
public class AuthenticationController {

	@Autowired
	private UserInfoService service;
	@Autowired
	private RoleService roleService;
	private static final String viewFolderPrefix ="auth/";
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView(viewFolderPrefix+"login");
		return mav;
	}
}
