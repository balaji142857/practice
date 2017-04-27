package com.krishnan.balaji.practice.service.redbus;

import java.util.List;
import java.util.Set;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.BusStop;

public interface BusStopService {

	BusStop create(BusStop busStop);

	Set<BusStop> list(int pageNumber);

	List<BusStop> listAll();

	BusStop getById(long id);

	BusStop update(BusStop busStop);
	
	List<BusStop> getByOperator(BusOperator operator);

	List<BusStop> getByOperatorPaged(int pageNumber, BusOperator operator);

}
