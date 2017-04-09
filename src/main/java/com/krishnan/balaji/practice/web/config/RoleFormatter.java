package com.krishnan.balaji.practice.web.config;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.krishnan.balaji.practice.model.Role;
import com.krishnan.balaji.practice.service.RoleService;
@Component
public class RoleFormatter implements Formatter<Role>{

	@Autowired RoleService service;
	
	@Override
	public String print(Role arg0, Locale arg1) {
		if(arg0==null)
			return null;
		else
			return arg0.getName();
	}

	@Override
	public Role parse(String arg0, Locale arg1) throws ParseException {
		System.out.println("roleFormatter parsing "+arg0);
		if(arg0==null)
			return null;
		System.out.println("brkqqq");
		Role role = service.getByName(arg0);
		System.out.println("Role is "+role+", and input is "+arg0);
		return role;
	}

}