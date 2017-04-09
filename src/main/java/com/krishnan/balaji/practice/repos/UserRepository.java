package com.krishnan.balaji.practice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	public User getByUsername(String name);
	public User getByEmail(String mailId);
}
