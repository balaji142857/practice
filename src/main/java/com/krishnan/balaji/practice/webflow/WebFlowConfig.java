package com.krishnan.balaji.practice.webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

import com.krishnan.balaji.practice.webflow.login.FlowLoginService;
import com.krishnan.balaji.practice.webflow.login.FlowLoginServiceImpl;
import com.krishnan.balaji.practice.webflow.quiz.QuizService;
import com.krishnan.balaji.practice.webflow.quiz.QuizServiceImpl;

@Configuration
@ImportResource({ "/WEB-INF/flows/webflow-config.xml" })
public class WebFlowConfig {

	@Autowired
	@Qualifier("flowExecutor")
	FlowExecutor flowExecutor;

	@Bean
	public FlowHandlerMapping flowHandlerMapping(
			@Autowired @Qualifier("flowRegistry") FlowDefinitionRegistry registry) {
		FlowHandlerMapping mapping = new FlowHandlerMapping();
		mapping.setFlowRegistry(registry);
		return mapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter adapter = new FlowHandlerAdapter();
		adapter.setFlowExecutor(flowExecutor);
		return adapter;
	}
	
	@Bean(name="loginService")
	public FlowLoginService loginService(){
		return new FlowLoginServiceImpl();
	}
	
	@Bean(name="quizService")
	public QuizService quizService(){
		return new QuizServiceImpl();
	}

}