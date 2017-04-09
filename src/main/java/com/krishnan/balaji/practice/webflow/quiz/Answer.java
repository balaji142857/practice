package com.krishnan.balaji.practice.webflow.quiz;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Answer implements Serializable{

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String text;
	@ManyToMany
	@JoinTable(name = "question_answers", joinColumns = @JoinColumn(name = "answer_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private Set<Question> associatedWith;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<Question> getAssociatedWith() {
		return associatedWith;
	}

	public void setAssociatedWith(Set<Question> associatedWith) {
		this.associatedWith = associatedWith;
	}

}
