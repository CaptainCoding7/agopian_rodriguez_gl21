package com.example.jetty_jersey.dao;

import java.awt.Image;
import java.util.List;

public class Pilot extends Passenger {

	private Image license;
	private Image medicalCertificate;
	private List<Flight> pilotFlightsList;

	/*
	 * private class FlightNoteBook { private int flightHours; }
	 * 
	 * private FlightNoteBook fNB;
	 */
	private int flightHours;

	// passenger version
	public Pilot(int userID, Birthday birthday, String firstName, String lastName, Image selfPicture, String phoneNumber,
			Image identityCard, String livingLocation, String description, List<Flight> passengerFlightsList) {
		super(userID, firstName, lastName, selfPicture, phoneNumber, identityCard, livingLocation, description,
				passengerFlightsList, birthday);
	}

	// passenger version
	public Pilot(int userID, int day, String month, int years, String firstName, String lastName, Image selfPicture,
			String phoneNumber, Image identityCard, String livingLocation, String description,
			List<Flight> passengerFlightsList) {
		super(userID, day, month, years, firstName, lastName, selfPicture, phoneNumber, identityCard, livingLocation,
				description, passengerFlightsList);
	}

	// pilot version
	public Pilot(int userID, Birthday birthday, String firstName, String lastName, Image selfPicture, String phoneNumber,
			Image identityCard, String livingLocation, String description, List<Flight> passengerFlightsList,
			Image license, Image medicalCertificate, List<Flight> pilotFlightsList, int flightHours) {
		super(userID, firstName, lastName, selfPicture, phoneNumber, identityCard, livingLocation, description,
				passengerFlightsList, birthday);
		this.license = license;
		this.medicalCertificate = medicalCertificate;
		this.pilotFlightsList = pilotFlightsList;
		this.flightHours = flightHours;
	}

	// pilot version
	public Pilot(int userID, int day, String month, int years, String firstName, String lastName, Image selfPicture,
			String phoneNumber, Image identityCard, String livingLocation, String description,
			List<Flight> passengerFlightsList, Image license, Image medicalCertificate, List<Flight> pilotFlightsList,
			int flightHours) {
		super(userID, day, month, years, firstName, lastName, selfPicture, phoneNumber, identityCard, livingLocation,
				description, passengerFlightsList);
		this.license = license;
		this.medicalCertificate = medicalCertificate;
		this.pilotFlightsList = pilotFlightsList;
		this.flightHours = flightHours;
	}

	public Pilot(int userID) {
		super(userID);
		this.license = null;
		this.medicalCertificate = null;
		this.pilotFlightsList = null;
		this.flightHours = 0;

	}


	public Image getMedicalCertificate() {
		return medicalCertificate;
	}

	public void setMedicalCertificate(Image medicalCertificate) {
		this.medicalCertificate = medicalCertificate;
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
