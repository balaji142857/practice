package com.krishnan.balaji.practice.service.redbus;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.BusStop;
import com.krishnan.balaji.practice.repos.redbus.BusStopsRepository;



@Service
@Transactional("transactionManager")
public class BusStopServiceImpl implements BusStopService{

	@Autowired
	BusStopsRepository repo;
	@Autowired BusOperatorService operatorService;
	@PersistenceContext EntityManager em;
	
	@Override
	public BusStop create(BusStop busStop) {
		repo.save(busStop);
		return busStop;
	}

	@Override
	public Set<BusStop> list(int pageNumber) {
		//TODO move the count to properties
		
		Pageable pageable = new PageRequest(pageNumber,20);
		Page<BusStop> page = repo.findAll(pageable);
		Iterator<BusStop> busStopIterator = page.iterator();
		Set<BusStop> busStops = new LinkedHashSet<>();
		while(busStopIterator.hasNext()){
			busStops.add(busStopIterator.next());
		}
		return busStops;
	}
	
	@Override
	public List<BusStop> listAll() {
		List<BusStop> busStops = repo.findAll();
		return busStops;
	}

	@Override
	public BusStop getById(long id,boolean fetchRoutes) {
		Query q = null;
		if(fetchRoutes)
			q = em.createQuery("SELECT b FROM BusStop b JOIN FETCH b.associatedRoutes WHERE b.id= :id");
		else
			q = em.createQuery("SELECT b FROM BusStop WHERE b.id= :id");
		q.setParameter("id", id);
		List<BusStop> a = q.getResultList();
		if(null != a && a.size()==1)
			return a.get(0);
		else return null;
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery cq =  cb.createQuery(BusStop.class);
		Root<BusStop> root = cq.from(BusStop.class);
		ParameterExpression<Integer> param = cb.parameter(Integer.class);
		cq.select(root).where(cb.equal(root.get(""), param));
		em.createQuery(cq).getResultList();*/
		//return repo.findOne(id);
	}

	@Override
	public BusStop update(BusStop busStop) {
		return em.merge(busStop);
	}

	@Override	
	public List<BusStop> getByOperatorPaged(int pageNumber,BusOperator operator) {
		int pageSize = 10;
		Query query = em.createQuery("from BusStop where operator.id = ?");
		query.setParameter(1, operator.getId());
		query.setFirstResult(pageSize*(pageNumber-1));
		query.setMaxResults(pageSize);
		List<BusStop> list = query.getResultList();
		return list;
	}
	
	@Override
	public List<BusStop> getByOperator(BusOperator operator) {
		Query query = em.createQuery("from BusStop where operator.id = ?");
		query.setParameter(1, operator.getId());
		List<BusStop> list = query.getResultList();
		return list;
	}

}