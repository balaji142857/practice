package com.krishnan.balaji.practice.model.a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Bus bus;
	 

}
