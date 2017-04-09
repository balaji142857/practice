package com.krishnan.balaji.practice.service;

import java.util.LinkedHashSet;
import java.util.Set;

//import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.Role;
import com.krishnan.balaji.practice.repos.RoleRepository;

@Service
@Transactional("transactionManager")
public class RoleServiceImpl implements RoleService{

	@Autowired RoleRepository repo;

	@Override
	public Role create(Role role) {
		return repo.save(role);
	}

	@Override
	public Role get(long id) {
		return repo.findOne(id);
	}

	@Override
	public Set<Role> get() {
		Iterable<Role> temp = repo.findAll();
		final Set<Role> roles = new LinkedHashSet<Role>();
		if(temp!=null)
			temp.forEach(roles::add);
		return roles;
	}

	@Override
	public Role getByName(String name) {
		System.out.println("brk2222");
		return repo.getByName(name);
	}

	@Override
	public Role update(Role role) {
		return repo.save(role);
	}

	@Override
	public void delete(Role role) {
		repo.delete(role);;
	}

	@Override
	public void delete(long id) {
		repo.delete(id);
	}
}
