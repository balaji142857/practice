package com.krishnan.balaji.practice.service.redbus;

import java.util.Set;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.Trip;

public interface TripService {

	public Trip create(Trip trip) ;

	public Set<Trip> listByOperator(BusOperator operator) ;

}
