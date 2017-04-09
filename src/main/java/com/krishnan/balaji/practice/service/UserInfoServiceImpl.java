package com.krishnan.balaji.practice.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.User;
import com.krishnan.balaji.practice.repos.UserRepository;

@Service
@Transactional("tranactionManager")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserRepository repo;

	@Override
	public User create(User user) {
		return repo.save(user);
	}

	@Override
	public User getById(long id) {
		return repo.findOne(id);
	}

	@Override
	public User getByName(String username) {
		return repo.getByUsername(username);
	}

	@Override
	public User getByEmail(String email) {
		return repo.getByEmail(email);
	}

	@Override
	public Set<User> get() {
		Iterable<User> temp = repo.findAll();
		Set<User> user = new LinkedHashSet<User>();
		if (temp != null)
			temp.forEach(user::add);
		return user;
	}

	@Override
	public User update(User user) {
		return repo.save(user);
	}

	@Override
	public void delete(long id) {
		repo.delete(id);
	}

	@Override
	public void deleteByName(String name) {
	}

	@Override
	public void deleteByEmail(String email) {
	}

}
