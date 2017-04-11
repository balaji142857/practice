package com.krishnan.balaji.practice.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.krishnan.balaji.practice.batch.simple.ExamResult;

@Configuration
@ComponentScan(basePackages="com.krishnan.balaji.practice.batch")
public class BatchConfig {

	@Bean
	public MapJobRepositoryFactoryBean jobRepository() {
		return new MapJobRepositoryFactoryBean();
	}

	@Bean
	public JobBuilderFactory jobBuilderFactory(JobRepository repository) {
		JobBuilderFactory jobBuilders = new JobBuilderFactory(repository);
		return jobBuilders;
	}
	

	@Bean
	public JobLauncher jobLauncher(JobRepository repository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(repository);
		return launcher;
	}
	
	@Bean(name="batchTransactionManager")
	public ResourcelessTransactionManager batchTransactionManager() {
		return new ResourcelessTransactionManager();
	}
		
	
	@Bean
	public StepBuilderFactory stepBuilderFactory(JobRepository repo){
		StepBuilderFactory factory = new StepBuilderFactory(repo, batchTransactionManager());
		return factory;
	}
	

	@Bean
	public Step step(JobRepository repository,
			PlatformTransactionManager batchTransactionManager,
			@Qualifier("simpleItemReader") ItemReader<ExamResult> flatFileItemReader,
			@Qualifier("simpleItemWriter") ItemWriter<ExamResult> xmlItemWriter,
			@Qualifier("simpleItemProcessor") ItemProcessor<ExamResult, ExamResult> itemProcessor,
			@Qualifier("simpleItemListener") JobExecutionListener jobListener
			) throws Exception {
		return stepBuilderFactory(repository)
				.get("step")
				.<ExamResult, ExamResult> chunk(1)
				.reader(flatFileItemReader)
				.processor(itemProcessor)
				.writer(xmlItemWriter)
				.listener(jobListener)
				.build();
	}
	
	@Bean
	public Job flatfileToDbJob(@Qualifier("simpleItemListener") JobExecutionListener listener,
			Step step) throws Exception {
		return jobBuilderFactory(jobRepository().getObject())
				.get("someJob")
				.listener(listener)
				.start(step)
				.build();
	}
	
}