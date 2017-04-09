package com.krishnan.balaji.practice.webflow.login;

public interface FlowLoginService {

	public String performLogin(LoginCredentials loginCredentials)
			throws IncorrectLoginCredentialsException;
}
