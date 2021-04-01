package com.ufly;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.persistence.ElementCollection;

@PersistenceCapable
public class Pilot extends Passenger {

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
	public Pilot(Birthday birthday, String firstName, String lastName, Image selfPicture, String phoneNumber,
			String livingLocation, List<Flight> passengerFlightsList,
			Image license, List<Flight> pilotFlightsList, int flightHours) {
		super(firstName, lastName, phoneNumber, livingLocation,	passengerFlightsList, birthday);
		this.license = license;
		this.pilotFlightsList = pilotFlightsList;
		this.flightHours = flightHours;
	}

	// pilot version
	public Pilot(int day, int month, int years, String firstName, String lastName,
			String phoneNumber, String livingLocation, List<Flight> passengerFlightsList, Image license, List<Flight> pilotFlightsList,
			int flightHours) {
		super(day, month, years, firstName, lastName, phoneNumber, livingLocation, passengerFlightsList);
		this.license = license;
		this.pilotFlightsList = pilotFlightsList;
		this.flightHours = flightHours;
	}

	public Pilot() {
		super();
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

}
