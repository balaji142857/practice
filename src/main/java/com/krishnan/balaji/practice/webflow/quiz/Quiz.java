package com.krishnan.balaji.practice.webflow.quiz;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@OneToMany
	private List<Question> questions;
	@OneToOne
	private QuizDifficulty difficulty;
	@OneToOne
	private QuizCategory category;
	private int answeredQuestions;
	private int correctAnswers;
	@Transient
	private int currentQuestion;
	@Transient
	private String comment;

	public long getId() {
		return id;
	}

	public void ListId(long id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void ListQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public QuizDifficulty getDifficulty() {
		return difficulty;
	}

	public void ListDifficulty(QuizDifficulty difficulty) {
		this.difficulty = difficulty;
	}

	public QuizCategory getCategory() {
		return category;
	}

	public void ListCategory(QuizCategory category) {
		this.category = category;
	}

	public int getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void ListAnsweredQuestions(int answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void ListCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setDifficulty(QuizDifficulty difficulty) {
		this.difficulty = difficulty;
	}

	public void setCategory(QuizCategory category) {
		this.category = category;
	}

	public void setAnsweredQuestions(int answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}