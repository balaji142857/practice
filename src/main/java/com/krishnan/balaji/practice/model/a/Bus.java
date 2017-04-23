package com.krishnan.balaji.practice.model.a;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//the type of bus - sleeper, AC, semi, seating, charging...
@Entity
public class Bus {

	public Bus() {
		chargingAvailable = false;
		gpsTrackingAvailable = false;
	}

	@Id
	@GeneratedValue
	private long id;
	private String model;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="FK_BUS_OPERATOR"))
	private BusOperator owningEntity;
	private BusType busType;
	private boolean chargingAvailable;
	private boolean gpsTrackingAvailable;
	private int seatCapacity;
	@Column(unique=true)
	private String regNumber;

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

	public boolean isChargingAvailable() {
		return chargingAvailable;
	}

	public void setChargingAvailable(boolean isChargingAvailable) {
		this.chargingAvailable = isChargingAvailable;
	}

	public boolean isGpsTrackingAvailable() {
		return gpsTrackingAvailable;
	}

	public void setGpsTrackingAvailable(boolean isGPSTrackingAvailable) {
		this.gpsTrackingAvailable = isGPSTrackingAvailable;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	

}