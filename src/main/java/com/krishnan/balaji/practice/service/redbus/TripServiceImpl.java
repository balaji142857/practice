package com.krishnan.balaji.practice.service.redbus;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.Trip;
import com.krishnan.balaji.practice.repos.redbus.TripRepository;

@Service
@Transactional("transactionManager")
public class TripServiceImpl implements TripService{

	@Autowired TripRepository repo;
	@PersistenceContext EntityManager em;
	
	@Override
	public Trip create(Trip trip) {
		return repo.save(trip);
	}

	@Override
	public Set<Trip> listByOperator(BusOperator operator) {
		return null;
	}

}
