package com.krishnan.balaji.practice.batch.simple;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
public class SimpleBatchConfig {

	@Bean(name="simpleItemReader")
	public ItemReader<ExamResult> flatFileItemReader() {
		FlatFileItemReader<ExamResult> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("examResult.txt"));
		DefaultLineMapper<ExamResult> lineMapper = new DefaultLineMapper<>();
		lineMapper.setFieldSetMapper(new ExamResultFieldSetMapper());
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("|");
		lineMapper.setLineTokenizer(tokenizer);
		reader.setLineMapper(lineMapper);
		return reader;
	}

	@Bean(name="simpleItemWriter")
	public ItemWriter<ExamResult> xmlItemWriter() throws URISyntaxException {
		StaxEventItemWriter<ExamResult> writer = new StaxEventItemWriter<>();
		writer.setResource(new FileSystemResource(Paths.get(
				new URI("file:////tmp/examResult.xml")).toFile()));
		writer.setRootTagName("UniversityExamResultList");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(ExamResult.class);
		writer.setMarshaller(marshaller);
		return writer;
	}

	@Bean(name="simpleItemProcessor")
	public ItemProcessor<ExamResult, ExamResult> itemProcessor() {
		return new ExamResultItemProcessor();
	}

	@Bean(name="simpleItemListener")
	public ExamResultJobListener jobListener() {
		return new ExamResultJobListener();
	}
}
