package com.ufly;

import java.awt.Image;

import javax.jdo.annotations.*;

@PersistenceCapable
public class Aircraft {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int aircraftID;
	private String aircraftModel;
	private String owner;
	private String registration;
	private int seatNumber;
	private int flightHours;
	private int rentingPrice;
	private Image picture;
	
	public Aircraft(int aircraftID,String aircraftModel, String owner, String registration,
			int seatNumber, int flightHours, int rentingPrice, Image picture) {
		this.aircraftID=aircraftID;
		this.aircraftModel = aircraftModel;
		this.owner = owner;
		this.registration = registration;
		this.seatNumber = seatNumber;
		this.flightHours = flightHours;
		this.rentingPrice = rentingPrice;
		this.picture = picture;
	}
	
	public Aircraft(int aircraftID) {
		this.aircraftID=aircraftID;
		this.aircraftModel = "";
		this.owner = "";
		this.registration = "";
		this.seatNumber = 0;
		this.flightHours = 0;
		this.rentingPrice = 0;
		this.picture = null;
	}

	public int getAircraftID() {
		return aircraftID;
	}

	public void setAircraftID(int aircraftID) {
		this.aircraftID=aircraftID;
	}
	
	public String getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public int getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(int flightHours) {
		this.flightHours = flightHours;
	}
	
	public int getRentingPrice() {
		return rentingPrice;
	}

	public void setRentingPrice(int rentingPrice) {
		this.rentingPrice = rentingPrice;
	}
	
	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}
	
	
}

	
