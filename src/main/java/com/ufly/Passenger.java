package com.ufly;

import java.awt.*;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.ElementCollection;

@PersistenceCapable
public class Passenger {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int userID;
	private String firstName;
	private String lastName;
	//private Image selfPicture;
	private String phoneNumber;
	//private Image identityCard;
	private String livingLocation;
	
	//private String description;
	
	@Persistent(defaultFetchGroup = "true")	
	private List<Flight> passengerFlightsList;
	
	
	protected class Birthday {
		private int day;
		private int month;
		private int years;
	}
	
	private Birthday birthday;
	
	
	public Passenger(String firstName, String lastName, String phoneNumber,
			String livingLocation, List<Flight> passengerFlightsList, Birthday birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		//this.selfPicture = selfPicture;
		this.phoneNumber = phoneNumber;
		//this.identityCard = identityCard;
		this.livingLocation = livingLocation;
		//this.description = description;
		this.passengerFlightsList = passengerFlightsList;
		this.birthday = birthday;
	}

	public Passenger(int day, int month, int years, String firstName, String lastName, 
			String phoneNumber, String livingLocation, List<Flight> passengerFlightsList) {
		this.birthday = new Birthday();
		this.birthday.day = day;
		this.birthday.month = month;
		this.birthday.years = years;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.selfPicture = selfPicture;
		this.phoneNumber = phoneNumber;
		//this.identityCard = identityCard;
		this.livingLocation = livingLocation;
		//this.description = description;
		this.passengerFlightsList = passengerFlightsList;
	}
	
	public Passenger() {
		this.birthday = null;
		this.firstName = "";
		this.lastName = "";
		//this.selfPicture = null;
		this.phoneNumber = "";
		//this.identityCard = null;
		this.livingLocation = "";
		//this.description = "defaul";
		this.passengerFlightsList = null;
	}	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public Birthday getBirthday() {
		return birthday;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	
	public int getBirthdayDay() {
		return birthday.day;
	}

	public void setBirthdayDay(int day) {
		this.birthday.day = day;
	}
	
	public int getBirthdayMonth() {
		return birthday.month;
	}

	public void setBirthdayMonth(int month) {
		this.birthday.month = month;
	}
	
	public int getBirthdayYears() {
		return birthday.years;
	}

	public void setBirthdayYears(int years) {
		this.birthday.years = years;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getLivingLocation() {
		return livingLocation;
	}

	public void setLivingLocation(String livingLocation) {
		this.livingLocation = livingLocation;
	}


	public List<Flight> getPassengerFlightsList() {
		return passengerFlightsList;
	}

	public void setPassengerFlightsList(List<Flight> passengerFlightsList) {
		this.passengerFlightsList = passengerFlightsList;
	}

}
