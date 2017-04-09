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
	public StepBuilderFactory stepBuilders(JobRepository jobRepository,PlatformTransactionManager transactionManager){
		StepBuilderFactory factory = new StepBuilderFactory(jobRepository, transactionManager);
		return factory;
	}
	
	@Bean
	public JobBuilderFactory jobBuilders(JobRepository repository) {
		JobBuilderFactory jobBuilders = new JobBuilderFactory(repository);
		return jobBuilders;
	}

	@Bean
	public MapJobRepositoryFactoryBean jobRepository() {
		return new MapJobRepositoryFactoryBean();
	}

	@Bean
	public JobLauncher jobLauncher(JobRepository repository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(repository);
		return launcher;
	}


	@Bean
	public ResourcelessTransactionManager batchTransactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public Job flatfileToDbJob(@Qualifier("simpleItemListener") JobExecutionListener listener,
			Step step) throws Exception {
		return jobBuilders(jobRepository().getObject())
				.get("someJob")
				.listener(listener)
				.start(step)
				.build();
	}

	@Bean
	public Step step(JobRepository repository,
			PlatformTransactionManager batchTransactionManager,
			@Qualifier("simpleItemReader") ItemReader<ExamResult> flatFileItemReader,
			@Qualifier("simpleItemWriter") ItemWriter<ExamResult> xmlItemWriter,
			@Qualifier("simpleItemProcessor") ItemProcessor<ExamResult, ExamResult> itemProcessor,
			@Qualifier("simpleItemListener") JobExecutionListener jobListener
			) throws Exception {
		return stepBuilders(repository,batchTransactionManager)
				.get("step")
				.<ExamResult, ExamResult> chunk(1)
				.reader(flatFileItemReader)
				.processor(itemProcessor)
				.writer(xmlItemWriter)
				.listener(jobListener)
				.build();
	}
}