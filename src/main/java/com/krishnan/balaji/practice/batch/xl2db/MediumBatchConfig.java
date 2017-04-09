package com.krishnan.balaji.practice.batch.xl2db;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.krishnan.balaji.practice.batch.simple.ExamResult;
import com.krishnan.balaji.practice.batch.simple.ExamResultItemProcessor;
import com.krishnan.balaji.practice.batch.simple.ExamResultJobListener;


public class MediumBatchConfig {

	@Bean(name="excelIteamReader")
	public ItemReader<ExpenseModel> flatFileItemReader() {
		  PoiItemReader<ExpenseModel> reader = new PoiItemReader<>();
	        reader.setLinesToSkip(1);
	        //TODO
	        reader.setResource(new ClassPathResource("data/students.xlsx"));
	        reader.setRowMapper(excelRowMapper());
	        return reader;
	}
	
	private RowMapper<ExpenseModel> excelRowMapper() {
		ExpenseRowMapper rowMapper = new ExpenseRowMapper();
        return rowMapper;
    }

	@Bean(name="dbItemWriter")
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

	@Bean(name="financeItemProcessor")
	public ItemProcessor<ExamResult, ExamResult> itemProcessor() {
		return new ExamResultItemProcessor();
	}

	@Bean(name="mediumJobListener")
	public ExamResultJobListener jobListener() {
		return new ExamResultJobListener();
	}
}
