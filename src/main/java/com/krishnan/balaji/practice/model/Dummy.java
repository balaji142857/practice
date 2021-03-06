package com.krishnan.balaji.practice.model;

import java.io.File;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.krishnan.balaji.practice.model.validation.Gender;
import com.krishnan.balaji.practice.model.validation.Phone;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Dummy extends AuditInfo {

	@Id
	@GeneratedValue
	private long id;
	@NotNull
	@Min(18)
	@Max(100)
	private long someNumber;
	@Size(min = 3, max = 30)
	private String name;
	@NotEmpty
	@Email
	private String email;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "dummy_hobbies", joinColumns = @JoinColumn(name = "hobby_id"))
	private Set<String> hobbies;
	@Gender
	private String gender;
	// checkbox
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "dummy_subscriptions", joinColumns = @JoinColumn(name = "subscription_id"))
	private Set<String> subscriptions;
	@Phone
	private String phone;
	// single file upload - to disk
	@Transient
	private File someFile;
	// single file upload to DB - some image content like avatar - display on
	// page
	@Lob
	private byte[] someImage;
	@Version
	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(long someNumber) {
		this.someNumber = someNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Set<String> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<String> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public File getSomeFile() {
		return someFile;
	}

	public void setSomeFile(File someFile) {
		this.someFile = someFile;
	}

	public byte[] getSomeImage() {
		return someImage;
	}

	public void setSomeImage(byte[] someImage) {
		this.someImage = someImage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}