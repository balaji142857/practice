package com.krishnan.balaji.practice.service.redbus;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(BusOperatorServiceImpl.class);
	@Autowired
	BusOperatorsRepository repo;
	@Autowired
	BusRepository busRepo;
	@PersistenceContext
	EntityManager em;

	@Override
	public BusOperator get(long id) {
		return get(id,false);
	}

	@Override
	public BusOperator get(long id, boolean initializeBuses) {
		log.info("getting bus operator "+id+" and loading buses: "+initializeBuses);
		return repo.getBusOperator(id, initializeBuses);
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
		log.info("insdie service add Bus");
		BusOperator operator = get(operatorId);
		log.info("repo operator name is "+operator.getName()+" and id is "+operator.getEmail());
		bus.setOwningEntity(operator);
		log.info("set owning entity for bus");
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