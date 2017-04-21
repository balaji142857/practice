package com.krishnan.balaji.practice.model.a;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Route {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@ManyToOne
	private BusOperator operator;
	@OneToMany
	private Set<BusStop> stops;
	/* can be derived from the stops - first and lost
	 * private Place origin;
	private Place destination;*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BusOperator getOperator() {
		return operator;
	}

	public void setOperator(BusOperator operator) {
		this.operator = operator;
	}

	public Set<BusStop> getStops() {
		return stops;
	}

	public void setStops(Set<BusStop> stops) {
		this.stops = stops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}