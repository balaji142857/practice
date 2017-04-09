package com.krishnan.balaji.practice.webflow.quiz;

public interface QuizService {
	
	public Quiz initialize();
	
	public Quiz loadQuizOptions(Quiz quizModel);
	
	public Question next(Quiz quiz, Long selectedAnswerId);
	
	public Quiz finish(Quiz quiz);

}
