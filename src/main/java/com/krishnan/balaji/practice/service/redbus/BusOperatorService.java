package com.krishnan.balaji.practice.service.redbus;

import java.util.Set;

import com.krishnan.balaji.practice.model.a.Bus;
import com.krishnan.balaji.practice.model.a.BusOperator;

public interface BusOperatorService {
	
	public BusOperator get(long id);
	public BusOperator get(long id, boolean initializeBuses);
	public BusOperator create(BusOperator operator);
	public BusOperator edit(BusOperator operator);
	public Set<BusOperator> list();
	
	public Bus addBus(long operatorId,Bus bus);
	public Bus getBus(long operatorId, long id);
	public Bus edit(long operatorId, Bus bus);
	public Set<Bus> listBuses(long operatorId);
	public Bus getBusByRegistrationNumber(BusOperator operator, String registrationNumber);
	public Bus getBus(long busId);
	
	

}
