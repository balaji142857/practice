package com.krishnan.balaji.practice.service.redbus;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.Bus;
import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.repos.redbus.BusOperatorsRepository;
import com.krishnan.balaji.practice.repos.redbus.BusRepository;

@Service
@Transactional("transactionManager")
public class BusOperatorServiceImpl implements BusOperatorService {

	@Autowired
	BusOperatorsRepository repo;
	@Autowired
	BusRepository busRepo;
	@PersistenceContext
	EntityManager em;

	@Override
	public BusOperator get(long id) {
		return repo.findOne(id);
	}

	@Override
	public BusOperator create(BusOperator operator) {
		return repo.save(operator);
	}

	@Override
	public BusOperator edit(BusOperator operator) {
		em.merge(operator);
		return operator;
	}

	@Override
	public Set<BusOperator> list() {
		Iterable<BusOperator> a = repo.findAll();
		Iterator<BusOperator> b = a.iterator();
		Set<BusOperator> result = new LinkedHashSet<>();
		while (b.hasNext()) {
			result.add(b.next());
		}
		return result;
	}

	@Override
	public Bus addBus(long operatorId, Bus bus) {
		BusOperator operator = get(operatorId);
		bus.setOwningEntity(operator);
		busRepo.save(bus);
		return bus;
	}

	@Override
	public Bus getBus(long operatorId, long id) {
		return busRepo.findOne(id);
	}

	@Override
	public Bus edit(long operatorId, Bus bus) {
		em.merge(bus);
		return bus;
	}

	@Override
	public Set<Bus> listBuses(long operatorId) {
		
		
		return null;
	}

}