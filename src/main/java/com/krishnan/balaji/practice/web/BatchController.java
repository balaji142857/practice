package com.krishnan.balaji.practice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BatchController {

	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;
	private static final Logger logger = LoggerFactory
			.getLogger(BatchController.class);

	@GetMapping("/batch")
	public ModelAndView iDontCare() {
		ModelAndView mav  = new ModelAndView("test");
		JobExecution execution  = null;
		try {
			execution = jobLauncher.run(job, new JobParameters());
			logger.info("Job Exit Status : " + execution.getStatus());
		} catch (JobExecutionException e) {
			logger.error("Job ExamResult failed",e);
		}
		StringBuilder jobStatus = new StringBuilder();
		jobStatus.append("execution.getStartTime(): "+execution.getStartTime()+"\n")
		.append("execution.getEndTime(): "+execution.getEndTime()+"\n")
		.append("execution.getStatus(): "+execution.getStatus()+"\n")
		.append("execution.getLastUpdated() :"+execution.getLastUpdated()+"\n")
		.append("execution.getExitStatus(): "+ execution.getExitStatus()+"\n");
		mav.getModelMap().put("batchResult", "Batch Job triggered, overview : \n"+jobStatus.toString()+ "Check the logs for result");
		return mav;
	}

}
