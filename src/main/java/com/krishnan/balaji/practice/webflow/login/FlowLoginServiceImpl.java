package com.krishnan.balaji.practice.webflow.login;


public class FlowLoginServiceImpl implements FlowLoginService {

	@Override
	public String performLogin(LoginCredentials loginCredentials)
			throws IncorrectLoginCredentialsException {
		if (loginCredentials.getLoginName() != null
				&& loginCredentials.getLoginName().trim()
						.equalsIgnoreCase("alba")
				&& loginCredentials.getPassword() != null
				&& loginCredentials.getPassword().trim()
						.equalsIgnoreCase("pass")) {
			// user successfully logged in
			return "success";
		} else {
			throw new IncorrectLoginCredentialsException();
		}
	}
}
