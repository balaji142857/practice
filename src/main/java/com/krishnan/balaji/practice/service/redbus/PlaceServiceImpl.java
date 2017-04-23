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

import com.krishnan.balaji.practice.model.a.Place;
import com.krishnan.balaji.practice.repos.redbus.PlaceRepository;

@Service
@Transactional("transactionManager")
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	PlaceRepository repo;
	@PersistenceContext
	EntityManager em;

	@Override
	public Place create(Place place) {
		repo.save(place);
		return place;
	}

	@Override
	public Place update(Place place) {
		Place managedEntity = em.merge(place);
		return managedEntity;
	}

	@Override
	public Set<Place> list(int pageNum) {
		Pageable pageable = new PageRequest(pageNum, 20);
		Page<Place> page = repo.findAll(pageable);
		Iterator<Place> placeIterator = page.iterator();
		Set<Place> places = new LinkedHashSet<>();
		while(placeIterator.hasNext()){
			places.add(placeIterator.next());
		}
		return places;
	}

	@Override
	public Place get(long id) {
		return repo.findOne(id);
	}

	@Override
	public Set<Place> listAll() {
		//TODO have it in either ascending or descending order
		Iterable<Place> iterable = repo.findAll();
		Iterator<Place> placeIterator =  iterable.iterator();
		Set<Place> places = new LinkedHashSet<>();
		while(placeIterator.hasNext()){
			places.add(placeIterator.next());
		}
		
		return places;
	}

	@Override
	public void delete(Place place) {
		if(em.contains(place)){
			em.remove(place);
		}else{
			place = em.merge(place);
			em.remove(place);
		}		
	}
}