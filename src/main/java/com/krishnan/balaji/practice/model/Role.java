package com.krishnan.balaji.practice.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Role extends AuditInfo implements GrantedAuthority {

	private static final long serialVersionUID = -5150436536641186359L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@ManyToMany
	@JoinTable(name = "user_role", 
	inverseJoinColumns = @JoinColumn(name = "user_id"), 
	joinColumns = @JoinColumn(name = "role_id"))
	@JoinColumn(foreignKey=@ForeignKey(name="FK_ROLE_USERS"))
	private Set<User> users;
	@Version
	private int version;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}