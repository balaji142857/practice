package com.krishnan.balaji.practice.model.a;

import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class BusService {

	private long id;
	private String from;
	private String to;
	@OneToOne
	private BusOperator serviceProvider;
	@OneToOne
	private Bus bus;
	@OneToMany(mappedBy = "bus")
	private Set<Seat> seats;
}
