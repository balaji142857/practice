package com.krishnan.balaji.practice.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
public class Role implements GrantedAuthority {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	//@ManyToMany(fetch=FetchType.EAGER)
	@ManyToMany
	@JoinTable(name = "user_role",
	inverseJoinColumns = @JoinColumn(name = "user_id"), 
	joinColumns = @JoinColumn(name = "role_id"))
	private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return getName();
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
