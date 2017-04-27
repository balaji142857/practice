package com.krishnan.balaji.practice.service.redbus;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.BusOperator;
import com.krishnan.balaji.practice.model.a.BusStop;
import com.krishnan.balaji.practice.model.a.Route;
import com.krishnan.balaji.practice.repos.redbus.RouteRepository;
import com.krishnan.balaji.practice.util.BusStopTimeSort;

@Service
@Transactional("transactionManager")
public class RouteServiceImpl implements RouteService {

	private static final Logger log = LoggerFactory.getLogger(RouteServiceImpl.class);
	@Autowired
	RouteRepository repo;
	@PersistenceContext
	EntityManager em;

	@Override
	public Route create(Route route) {
		if (route.getStops() != null) {
			//TODO don't create a new instance of comparator every time
			//TODO get another param from controller/service client - if input is sorted dont bother sorting it again
			Collections.sort(route.getStops(),new BusStopTimeSort());
			BusStop lastStop = null;
			BusStop firstStop = null;
			route.setOrigin(route.getStops().get(0));
			route.setDestination(route.getStops().get(route.getStops().size()-1));
			firstStop = route.getOrigin();
			lastStop = route.getDestination();
			
			if (firstStop.getDay() == lastStop.getDay()) {
				route.setJourneyTime(Duration.between(firstStop.getArrival(), lastStop.getDeparture()));
				log.info("single day journey, time is "+route.getJourneyTime());
			}
			else{
				log.info("multi day journey");
				//TODO LocalTime.Midnight might be better fit - test it
				Duration firstDayDuration = Duration.between(firstStop.getArrival(), LocalTime.of(23, 59)).plusMinutes(1);
				log.info("first day duration is "+firstDayDuration.toString());
				Duration inBetween = Duration.ofHours((lastStop.getDay()-firstStop.getDay()-1)*24);
				log.info("duration inBetween is"+inBetween.toString());
				Duration lastDayDuration = Duration.between(LocalTime.of(0, 0), lastStop.getDeparture());
				log.info("duration on last day is"+lastDayDuration.toString());
				route.setJourneyTime(firstDayDuration.plus(lastDayDuration).plus(inBetween));
			}
			log.info("Route duration is "+route.getJourneyTime());
		} else
			log.error("busStops of route is null");
		repo.save(route);
		return route;
	}

	@Override
	public Route get(long id) {
		return repo.findOne(id);
	}

	@Override
	public Set<Route> list(int pageNum) {
		Pageable pageable = new PageRequest(pageNum, 20);
		Page<Route> page = repo.findAll(pageable);
		Iterator<Route> pageIterator = page.iterator();
		Set<Route> routes = new LinkedHashSet<>();
		while (pageIterator.hasNext()) {
			routes.add(pageIterator.next());
		}
		return routes;
	}

	@Override
	public Set<Route> listAll() {
		Iterable<Route> iterable = repo.findAll();
		Iterator<Route> routeIterator = iterable.iterator();
		Set<Route> routes = new LinkedHashSet<>();
		while (routeIterator.hasNext()) {
			routes.add(routeIterator.next());
		}
		return routes;
	}

	@Override
	public Route update(Route route) {
		return em.merge(route);
	}

	@Override
	public List<Route> listByOperator(int pageNum, BusOperator operator) {
		int pageSize = 10;
		Query query = em.createQuery("from Route where operator.id = ?");
		query.setParameter(1, operator.getId());
		query.setFirstResult(pageSize*(pageNum-1));
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

}
