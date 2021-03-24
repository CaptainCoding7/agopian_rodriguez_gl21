package com.ufly;

import java.awt.Image;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Pilot extends Passenger {

	private Image license;
	// flights list for which the user participate as a pilot
	private List<Flight> pilotFlightsList; 

	/*
	 * private class FlightNoteBook { private int flightHours; }
	 * 
	 * private FlightNoteBook fNB;
	 */
	private int flightHours;

	// pilot version
	public Pilot(Birthday birthday, String firstName, String lastName, Image selfPicture, String phoneNumber,
			Image identityCard, String livingLocation, String description, List<Flight> passengerFlightsList,
			Image license, List<Flight> pilotFlightsList, int flightHours) {
		super(firstName, lastName, selfPicture, phoneNumber, identityCard, livingLocation, description,
				passengerFlightsList, birthday);
		this.license = license;
		this.pilotFlightsList = pilotFlightsList;
		this.flightHours = flightHours;
	}

	// pilot version
	public Pilot(int day, int month, int years, String firstName, String lastName, Image selfPicture,
			String phoneNumber, Image identityCard, String livingLocation, String description,
			List<Flight> passengerFlightsList, Image license, List<Flight> pilotFlightsList,
			int flightHours) {
		super(day, month, years, firstName, lastName, selfPicture, phoneNumber, identityCard, livingLocation,
				description, passengerFlightsList);
		this.license = license;
		this.pilotFlightsList = pilotFlightsList;
		this.flightHours = flightHours;
	}

	public Pilot() {
		super();
		this.license = null;
		this.pilotFlightsList = null;
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
