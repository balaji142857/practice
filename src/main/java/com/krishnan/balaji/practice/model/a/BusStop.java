package com.krishnan.balaji.practice.model.a;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_STOP_OPERATOR"))
	private BusOperator operator;
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_STOP_PLACE"))
	private Place place;
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime arrival;
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime departure;
	@ManyToMany
	@JoinTable(name = "route_stops", joinColumns = @JoinColumn(name = "stop_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_STOP_ROUTE"))
	private Set<Route> associatedRoutes;
	private int day;
	@Transient
	private String displayName;

	public long getId() {
		return id;
	}

	public BusStop() {
		day = 1;
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

	public String getDisplayName() {
		return place.getDisplay() + " @ (in: " + arrival + ", out: " + departure + " )";
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public LocalTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}

	public Set<Route> getAssociatedRoutes() {
		return associatedRoutes;
	}

	public void setAssociatedRoutes(Set<Route> associatedRoutes) {
		this.associatedRoutes = associatedRoutes;
	}
}