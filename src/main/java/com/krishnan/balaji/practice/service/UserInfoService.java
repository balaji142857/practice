package com.krishnan.balaji.practice.service;

import java.util.Set;

import com.krishnan.balaji.practice.model.User;

public interface UserInfoService {

	public User create(User user);
	
	public User getById(long id);
	public User getByName(String username);
	public User getByEmail(String email);
	public Set<User> get();
	
	public User update(User user);
	
	public void delete(long id);
	public void deleteByName(String name);
	public void deleteByEmail(String email);
	
}
