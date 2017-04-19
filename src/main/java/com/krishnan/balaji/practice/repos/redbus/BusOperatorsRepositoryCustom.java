package com.krishnan.balaji.practice.repos.redbus;

import com.krishnan.balaji.practice.model.a.BusOperator;

public interface BusOperatorsRepositoryCustom {
	
	public BusOperator getBusOperator(long id, boolean loadBuses);

}
