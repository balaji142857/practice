package com.krishnan.balaji.practice.batch.xl2db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

public class ExpenseRowMapper implements RowMapper<ExpenseModel>{

	public ExpenseRowMapper(){
		
	}
	
	
	Map<String,Integer> fieldToColumnMapping  = null;
	
	@Override
	public ExpenseModel mapRow(RowSet rs) throws Exception {
		if (fieldToColumnMapping == null){
			fieldToColumnMapping = new HashMap<>();
			
		}
		return null;
	}

}
