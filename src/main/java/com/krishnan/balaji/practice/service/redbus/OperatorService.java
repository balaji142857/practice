package com.krishnan.balaji.practice.service.redbus;

import java.util.Set;

import com.krishnan.balaji.practice.model.a.BusOperator;

public interface OperatorService {
	
	public BusOperator get(long id);
	public BusOperator create(BusOperator operator);
	public BusOperator edit(BusOperator operator);
	public Set<BusOperator> list();

}
