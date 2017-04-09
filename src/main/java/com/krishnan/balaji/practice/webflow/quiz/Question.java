package com.krishnan.balaji.practice.webflow.quiz;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Question implements Serializable{

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String text;
	@ManyToMany
	@JoinTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "answer_id"))
	private List<Answer> answers;
	private Answer correctAnswer;

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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
