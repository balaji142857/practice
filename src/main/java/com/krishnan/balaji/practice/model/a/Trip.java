package com.krishnan.balaji.practice.model.a;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.krishnan.balaji.practice.util.LocalDateConverter;

@Entity
public class Trip {

	@Id
	@GeneratedValue
	private long id;
	@Convert(converter=LocalDateConverter.class)
	private LocalDate tripDate;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_trip_opeator"))
	private BusOperator operator;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_trip_bus"))
	private Bus bus;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_trip_route"))
	private Route route;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate startDate) {
		this.tripDate = startDate;
	}

	public BusOperator getOperator() {
		return operator;
	}

	public void setOperator(BusOperator operator) {
		this.operator = operator;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}
