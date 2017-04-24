package com.krishnan.balaji.practice.model.a.exceptions;

import java.time.LocalDate;

import com.krishnan.balaji.practice.model.a.Place;

/**
 * not an entity to be persisted
 * @author balaji142857
 *
 */
public class SearchParams {
	
	private LocalDate journeyStartDate;
	private Place from;
	private Place to;

}
