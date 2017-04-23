package com.krishnan.balaji.practice.repos.redbus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.Bus;
import com.krishnan.balaji.practice.model.a.BusOperator;

@Repository
@Transactional("transactionManager")
public class BusOperatorsRepositoryImpl implements BusOperatorsRepositoryCustom {

	/*@Autowired
	BusOperatorsRepository repo;*/
	@PersistenceContext
	EntityManager em;
	private static final Logger log = LoggerFactory.getLogger(BusOperatorsRepositoryImpl.class);

	@Override
	public BusOperator getBusOperator(long id, boolean loadBuses) {
		log.info("Inside getBusOperator with values "+id+", "+loadBuses);
		Session session = em.unwrap(Session.class);
		BusOperator operator = (BusOperator) session.get(BusOperator.class, id);
		if(loadBuses){
			log.info("Initializing the proxy objects");
			Hibernate.initialize(operator);
			if(null==operator)
				return null	;
			log.info(operator.getName());
			if(operator.getBuses()!=null){
				log.info("this operator has "+operator.getBuses().size()+" buses");
				for(Bus b: operator.getBuses()){
					log.info("bus id "+ b.getId());
					log.info("bus model "+ b.getModel());
					log.info("bus type" +b.getBusType());
					log.info("bus capacity "+ b.getSeatCapacity());
					
				}
			}else
				log.info("null bus collection for this operator "+id);
			
		}
		return operator;
	}

}
