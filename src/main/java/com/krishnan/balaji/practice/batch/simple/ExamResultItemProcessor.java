package com.krishnan.balaji.practice.batch.simple;

import org.springframework.batch.item.ItemProcessor;

 
public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{
 
    @Override
    public ExamResult process(ExamResult result) throws Exception {
        System.out.println("Processing result :"+result);
 
        if(result.getPercentage() < 60){
            return null;
        }
        return result;
    }
 
}