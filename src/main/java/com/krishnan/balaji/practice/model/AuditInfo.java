package com.krishnan.balaji.practice.model;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.krishnan.balaji.practice.util.LocalDateTimeConverter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditInfo {

	@CreatedBy
	private String createdBy;

	@LastModifiedBy
	private String updatedBy;

	@CreatedDate
	@Convert(converter=LocalDateTimeConverter.class)
	private LocalDateTime createdOn;

	@LastModifiedDate
	@Convert(converter=LocalDateTimeConverter.class)
	private LocalDateTime updatedOn;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}