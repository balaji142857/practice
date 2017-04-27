package com.krishnan.balaji.practice.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.Trip;

@Service
@Transactional("transactionManager")
public class TripRegistrationServiceImpl implements TripRegistrationService{

	@Override
	public Trip create(Trip trip) {
		return null;
	}

	@Override
	public Set<Trip> listByOperator(BusOperator operator) {
		return null;
	}

}
