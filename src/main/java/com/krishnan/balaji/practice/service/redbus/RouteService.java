package com.krishnan.balaji.practice.service.redbus;

import java.util.List;
import java.util.Set;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.Route;

public interface RouteService {

	public Route create(Route route);

	public Route get(long id);

	public Set<Route> list(int pageNum);
	
	public List<Route> listByOperator(int pageNum,BusOperator operator);

	public Set<Route> listAll();

	public Route update(Route route);

}
