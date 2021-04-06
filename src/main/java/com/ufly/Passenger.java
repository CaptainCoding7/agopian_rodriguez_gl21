package com.ufly;

import java.awt.*;
import java.time.LocalDate;
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
	private String mail;
	private String pwd;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String livingLocation;
	
	
	@Persistent(defaultFetchGroup = "true")	
	private List<Flight> passengerFlightsList;
	
	private LocalDate birthday;
	
	
	public Passenger(String mail, String pwd, String firstName, String lastName, String phoneNumber,
			String livingLocation, List<Flight> passengerFlightsList, String birthday) {
		this.mail=mail;
		this.setPwd(pwd);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.livingLocation = livingLocation;
		this.passengerFlightsList = passengerFlightsList;
		this.birthday = LocalDate.parse(birthday);
	}

	public Passenger(String mail, String pwd,int day, int month, int year, String firstName, String lastName, 
			String phoneNumber, String livingLocation, List<Flight> passengerFlightsList) {
		this.mail=mail;
		this.setPwd(pwd);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.livingLocation = livingLocation;
		this.passengerFlightsList = passengerFlightsList;
		this.birthday = LocalDate.of(year, month, day);
	}
	
	public Passenger() {
		this.birthday = null;
		this.firstName = "";
		this.lastName = "";
		this.phoneNumber = "";
		this.livingLocation = "";
		this.passengerFlightsList = null;
	}	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = LocalDate.parse(birthday);
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}