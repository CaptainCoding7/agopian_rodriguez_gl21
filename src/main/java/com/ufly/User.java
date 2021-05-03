package com.ufly;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.ElementCollection;
import javax.persistence.Id;

@PersistenceCapable
public class User {
	
	@PrimaryKey
	@Id
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int userID;
	private String mail;
	private String pwd;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String livingLocation;
	private boolean isApilot=false;
	
	
	@Persistent(defaultFetchGroup = "true")	
	private List<Flight> bookedFlightsList;
	
	private String birthday;
	
	
	public User(String mail, String pwd, String firstName, String lastName, String phoneNumber,
			String livingLocation, String birthday) {
		this.mail=mail;
		this.setPwd(pwd);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.livingLocation = livingLocation;
		this.bookedFlightsList = new ArrayList<Flight>();
		this.birthday = birthday;
	}


	public User() {
		this.birthday = null;
		this.firstName = "";
		this.lastName = "";
		this.phoneNumber = "";
		this.livingLocation = "";
		this.bookedFlightsList = null;
	}	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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


	public List<Flight> getBookedFlightsList() {
		return bookedFlightsList;
	}

	public void setBookedFlightsList(List<Flight> passengerFlightsList) {
		this.bookedFlightsList = passengerFlightsList;
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

	public boolean getIsApilot() {
		return isApilot;
	}

	public void setIsApilot(boolean isApilot) {
		this.isApilot = isApilot;
	}

}
