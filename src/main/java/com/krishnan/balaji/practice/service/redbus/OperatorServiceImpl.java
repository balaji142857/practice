package com.krishnan.balaji.practice.service.redbus;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.repos.redbus.OperatorsRepository;

@Service
@Transactional("transactionManager")
public class OperatorServiceImpl implements OperatorService{

	@Autowired
	OperatorsRepository repo;
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
		/*BusOperator repoInstance = em.find(BusOperator.class, operator.getId());//repo.findOne(operator.getId());
		operator.setId(repoInstance.getId());
		em.merge(operator);*/
		em.merge(operator);
		return operator;
	}

	@Override
	public Set<BusOperator> list() {
		Iterable<BusOperator> a = repo.findAll();
		Iterator<BusOperator> b = a.iterator();
		Set<BusOperator> result = new LinkedHashSet<>();
		while(b.hasNext()){
			result.add(b.next());
		}
		return result;
	}

}