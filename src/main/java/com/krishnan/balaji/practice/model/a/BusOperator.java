package com.krishnan.balaji.practice.model.a;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//like ARC, ABT, KPN
@Entity
public class BusOperator {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String name;
	@OneToMany(mappedBy="owningEntity")
	private Set<Bus> buses;
	private String contactName;
	private String contactNumber;
	private String headOfficeAddress;
	private String email;
	// rating

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

	public Set<Bus> getBuses() {
		return buses;
	}

	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getHeadOfficeAddress() {
		return headOfficeAddress;
	}

	public void setHeadOfficeAddress(String headOfficeAddress) {
		this.headOfficeAddress = headOfficeAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}