package com.ufly;

import java.awt.Image;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.ElementCollection;
import javax.persistence.Id;

@PersistenceCapable
public class PilotInfos{

	// the pilot take the same ID than the user who identifies him
	@PrimaryKey
	@Id
	private int userID;
	
	private Image license;
	
	// flights list for which the user participate as a pilot
	
	@Persistent(defaultFetchGroup = "true")
	private List<Flight> pilotFlightsList; 

	/*
	 * private class FlightNoteBook { private int flightHours; }
	 * 
	 * private FlightNoteBook fNB;
	 */
	private int flightHours;

	// pilot version
	public PilotInfos(int userID) {

		this.setUserID(userID);
		this.license = null;
		this.pilotFlightsList = new ArrayList<Flight>();
		this.flightHours = 0;
	}
	

	public List<Flight> getPilotFlightsList() {
		return pilotFlightsList;
	}

	public void setPilotFlightsList(List<Flight> pilotFlightsList) {
		this.pilotFlightsList = pilotFlightsList;
	}

	public int getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(int flightHours) {
		this.flightHours = flightHours;
	}

	public Image getLicense() {
		return license;
	}

	public void setLicense(Image license) {
		this.license = license;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}

}