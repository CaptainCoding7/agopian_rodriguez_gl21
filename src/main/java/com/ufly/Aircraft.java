package com.ufly;

import java.awt.Image;

import javax.jdo.annotations.*;

@PersistenceCapable
public class Aircraft {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int aircraftID;
	private String aircraftModel;
	private String registration;
	private int seatNumber;
	private Image picture;
	
	public Aircraft(String aircraftModel, String owner, String registration,
			int seatNumber, int flightHours, int rentingPrice, Image picture) {
		this.aircraftModel = aircraftModel;
		this.registration = registration;
		this.seatNumber = seatNumber;
		this.picture = picture;
	}
	
	public Aircraft() {
		this.aircraftModel = "";
		this.registration = "";
		this.seatNumber = 0;
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

	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}
	
	
}
