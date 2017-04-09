package com.krishnan.balaji.practice.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	@Query("select r from Role r where r.name = :roleName ")
	public Role getByName(@Param("roleName") String name);
}
