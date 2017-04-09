package com.krishnan.balaji.practice.webflow.quiz;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuizServiceImpl implements QuizService{

	private static final Logger logger = LoggerFactory
			.getLogger(QuizServiceImpl.class);

	@Override
	public Question next(Quiz quiz,Long answerId) {
		logger.info("Moving to next question");
		if(answerId!=null && answerId > 0){
			quiz.setAnsweredQuestions(quiz.getAnsweredQuestions()+1);
			if( quiz.getQuestions().get(quiz.getCurrentQuestion()).getCorrectAnswer().getId()==answerId){
				quiz.setCorrectAnswers(quiz.getCorrectAnswers()+1);
			}	
		}
		if(quiz.getCurrentQuestion() == quiz.getQuestions().size()-1){
			quiz.setComment("This is the last question.... next will just return the same question again and again");
			return quiz.getQuestions().get(quiz.getCurrentQuestion());
		}
		else
			quiz.setCurrentQuestion(quiz.getCurrentQuestion()+1);
			return quiz.getQuestions().get(quiz.getCurrentQuestion());
	}

	@Override
	public Quiz finish(Quiz quiz) {
		logger.info("finishing the quiz");
		logger.info("answeredQuestions: "+quiz.getAnsweredQuestions());
		logger.info("correctAnswers:"+ quiz.getCorrectAnswers());
		return quiz;
	}

	@Override
	public Quiz initialize() {
		return createQuiz();
	}

	@Override
	public Quiz loadQuizOptions(Quiz quizModel) {
		loadQuestions(quizModel);
		return quizModel;
	}


	private Quiz createQuiz() {
		Quiz quiz = new Quiz();
		QuizCategory cat = new QuizCategory();
		cat.setName("Spiritual");
		quiz.setCategory(cat);
		QuizDifficulty dif = new QuizDifficulty();
		dif.setName("medium");
		quiz.setDifficulty(dif);
		return quiz;
	}
	
	private void loadQuestions(Quiz quizModel) {
		for(int i=0;i <10; i++){
			Question q = new Question();
			q.setText("This is question number "+(i+1));
			q.setId(i);
			q.setAnswers(loadAnswers(q));
			q.setCorrectAnswer(q.getAnswers().get((int) Math.round(Math.random()*3)));
			if(quizModel.getQuestions()==null)
				quizModel.setQuestions(new ArrayList<Question>());
			logger.info("loaded question with id "+q.getId()+" and Question: "+q.getText());
			quizModel.getQuestions().add(q);
			}
	}

	private List<Answer> loadAnswers(Question q) {
		List<Answer> answers = new ArrayList<>();
		for(int i=0;i<4;i++){
			Answer ans = new Answer();
			ans.setId(i+1);
			ans.setText("This is some answer "+ Math.round(Math.random()*50));
			answers.add(ans);
		}
		logger.info("loaded answers"+answers.size()+" for question wtih id "+q.getId());
		return answers;
	}
}
