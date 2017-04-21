package com.krishnan.balaji.practice.model.a;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.krishnan.balaji.practice.util.LocalDateConverter;

@Entity
public class ActiveService {

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Route route;
	//@Temporal(value = TemporalType.DATE)
	@Convert(converter = LocalDateConverter.class)
	private LocalDate startDate;
	@OneToOne
	private Bus bus;
	@OneToOne
	private BusOperator operator;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

}