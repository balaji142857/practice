package com.krishnan.balaji.practice.service.redbus;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.a.Route;
import com.krishnan.balaji.practice.repos.redbus.RouteRepository;

@Service
@Transactional("transactionManager")
public class RouteServiceImpl implements RouteService {

	@Autowired
	RouteRepository repo;
	@PersistenceContext
	EntityManager em;

	@Override
	public Route create(Route route) {
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

}
