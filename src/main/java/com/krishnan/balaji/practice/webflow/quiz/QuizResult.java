package com.krishnan.balaji.practice.webflow.quiz;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuizResult implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	private Quiz quiz;
	private String playedAt;

}
