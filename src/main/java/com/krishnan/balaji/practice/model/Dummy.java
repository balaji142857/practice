package com.krishnan.balaji.practice.model;

import java.io.File;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.krishnan.balaji.practice.model.validation.Phone;

@Entity
@Table
public class Dummy {

	@Id
	@GeneratedValue
	private long id;
	@NotNull
	@Min(18)
	@Max(100)
	private long someNumber;
	// plain text
	@Size(min = 3, max = 30)
	private String name;
	// email validation
	@NotEmpty
	@Email
	private String email;
	// multiselect
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "dummy_hobbies", joinColumns = @JoinColumn(name = "hobby_id"))
	private Set<String> hobbies;
	// radio button
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

	// custom object
	/*
	 * private LocalDate someDate; // multiple file upload private Set<File>
	 * someFiles;
	 */

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

	/*
	 * public LocalDate getSomeDate() { return someDate; }
	 * 
	 * public void setSomeDate(LocalDate someDate) { this.someDate = someDate; }
	 * 
	 * public File getSomeFile() { return someFile; }
	 * 
	 * public void setSomeFile(File someFile) { this.someFile = someFile; }
	 * 
	 * public Set<File> getSomeFiles() { return someFiles; }
	 * 
	 * public void setSomeFiles(Set<File> someFiles) { this.someFiles =
	 * someFiles; }
	 * 
	 * public File getSomeImage() { return someImage; }
	 * 
	 * public void setSomeImage(File someImage) { this.someImage = someImage; }
	 */

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
}