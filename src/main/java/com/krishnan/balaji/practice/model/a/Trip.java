package com.krishnan.balaji.practice.model.a;

import java.time.LocalDate;

public class Trip {

	private long id;
	private LocalDate startDate;
	private BusOperator operator;
	private Bus bus;
	private Route route;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
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
