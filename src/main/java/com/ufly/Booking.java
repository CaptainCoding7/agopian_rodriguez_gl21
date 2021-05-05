package com.ufly;

import java.time.LocalDateTime;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Id;

@PersistenceCapable
public class Booking {
	
	@PrimaryKey
	@Id
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long bookingID;
	
	private long userID;
	private long flightID;
	private int nbSeats;
	private boolean validated;
	private String date;

	
	public Booking(long flightID, long userID, int nbSeats, String date) {
		
		this.flightID=flightID;
		this.userID=userID;
		this.nbSeats=nbSeats;
		this.date= date;
		this.setValidated(false);
		
	
	}
	
	public long getBookingID() {
		return bookingID;
	}
	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}
	public long getFlightID() {
		return flightID;
	}
	public void setFlightID(long flightID) {
		this.flightID = flightID;
	}
	public int getNbSeats() {
		return nbSeats;
	}
	public void setNbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	
}
