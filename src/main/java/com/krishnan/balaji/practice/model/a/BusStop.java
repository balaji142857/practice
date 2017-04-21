package com.krishnan.balaji.practice.model.a;

import java.time.LocalTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.krishnan.balaji.practice.util.LocalTimeConverter;

@Entity
public class BusStop {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private BusOperator operator;
	@OneToOne
	private Place place;
	// @Temporal(value = TemporalType.TIME)
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime time;
	@ManyToOne
	private Route route;
	private int ordinal;
	@Transient
	private String displayName;

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

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public String getDisplayName() {
		return place.getDisplay() + " @ " + time;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}