package com.krishnan.balaji.practice.service.redbus;

import java.util.Set;

import com.krishnan.balaji.practice.model.a.Place;

public interface PlaceService {

	Place create(Place place);

	Place update(Place place);

	Set<Place> list(int pageNum);
	
	Place get(long id);

	Set<Place> listAll();

	

}
