package com.krishnan.balaji.practice.model.a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//the type of bus - sleeper, AC, semi, seating, charging...
@Entity
public class Bus {

	public Bus() {
		// setting the defaults
		isSleeper = true;
		isSeatingOnly = false;
		isSemiSleeper = false;
		isChargingAvailable = false;
		isACavailable = true;
		isGPSTrackingAvailable = true;
	}

	@Id
	@GeneratedValue
	private long id;
	private String model;
	@ManyToOne
	private BusOperator owningEntity;
	private boolean isSleeper;
	private boolean isSeatingOnly;
	private boolean isSemiSleeper;
	private boolean isChargingAvailable;
	private boolean isACavailable;
	private boolean isGPSTrackingAvailable;
	private int seatCapacity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BusOperator getOwningEntity() {
		return owningEntity;
	}

	public void setOwningEntity(BusOperator owningEntity) {
		this.owningEntity = owningEntity;
	}

	public boolean isSleeper() {
		return isSleeper;
	}

	public void setSleeper(boolean isSleeper) {
		this.isSleeper = isSleeper;
	}

	public boolean isSeatingOnly() {
		return isSeatingOnly;
	}

	public void setSeatingOnly(boolean isSeatingOnly) {
		this.isSeatingOnly = isSeatingOnly;
	}

	public boolean isSemiSleeper() {
		return isSemiSleeper;
	}

	public void setSemiSleeper(boolean isSemiSleeper) {
		this.isSemiSleeper = isSemiSleeper;
	}

	public boolean isChargingAvailable() {
		return isChargingAvailable;
	}

	public void setChargingAvailable(boolean isChargingAvailable) {
		this.isChargingAvailable = isChargingAvailable;
	}

	public boolean isACavailable() {
		return isACavailable;
	}

	public void setACavailable(boolean isACavailable) {
		this.isACavailable = isACavailable;
	}

	public boolean isGPSTrackingAvailable() {
		return isGPSTrackingAvailable;
	}

	public void setGPSTrackingAvailable(boolean isGPSTrackingAvailable) {
		this.isGPSTrackingAvailable = isGPSTrackingAvailable;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

}
