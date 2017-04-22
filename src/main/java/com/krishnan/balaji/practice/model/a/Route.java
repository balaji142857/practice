package com.krishnan.balaji.practice.model.a;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.krishnan.balaji.practice.util.DurationConverter;

@Entity
public class Route {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@ManyToOne
	private BusOperator operator;
	@OneToMany
	private List<BusStop> stops;
	// can be derived from the stops set by looking up first & last
	// adding directly to model for easier reference
	@OneToOne
	private BusStop origin;
	@OneToOne
	private BusStop destination;	
	@Convert(converter = DurationConverter.class)
	private Duration journeyTime;

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

	public List<BusStop> getStops() {
		return stops;
	}

	public void setStops(List<BusStop> stops) {
		this.stops = stops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BusStop getOrigin() {
		return origin;
	}

	public void setOrigin(BusStop origin) {
		this.origin = origin;
	}

	public BusStop getDestination() {
		return destination;
	}

	public void setDestination(BusStop destination) {
		this.destination = destination;
	}

	public Duration getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(Duration journeyTime) {
		this.journeyTime = journeyTime;
	}

}