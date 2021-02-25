package com.example.jetty_jersey.dao;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Flight {
			
	private int flightID;
	private Aircraft aircraft;
	private String typeOfFlight;
	private String departureAirport;
	private String arrivalAirport;
	private LocalTime duration;
	private LocalDate depatureDate;
	private LocalDate arrivalDate;
	
	//thing about the last date before close the booking
	
	private String flightTitle;
	private String flightDescription;
	private List<Passenger> passengerInFlight;
	private int pricePerPassenger;
	
	public Flight(int flightID, Aircraft aircraft, String typeOfFlight, String departureAirport, String arrivalAirport, LocalTime duration,
			LocalDate depatureDate, LocalDate arrivalDate, String flightTitle, String flightDescription,
			List<Passenger> passengerInFlight, int pricePerPassenger) {
		this.flightID=flightID;
		this.aircraft = aircraft;
		this.typeOfFlight = typeOfFlight;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.duration = duration;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
		this.flightTitle = flightTitle;
		this.flightDescription = flightDescription;
		this.passengerInFlight = passengerInFlight;
		this.pricePerPassenger = pricePerPassenger;
	}
	
	public Flight(int flightID)
	{
		this.flightID=flightID;
		this.aircraft = null;
		this.typeOfFlight = "";
		this.departureAirport = "";
		this.arrivalAirport = "";
		this.duration = null;
		this.depatureDate = null;
		this.arrivalDate = null;
		this.flightTitle = "";
		this.flightDescription = "";
		this.passengerInFlight = null;
		this.pricePerPassenger = 0;	
	}
	
	public int getFlightID(){
		return this.flightID;
	}

	public void setFlightID(int flightID){
		this.flightID=flightID;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public String getTypeOfFlight() {
		return typeOfFlight;
	}

	public void setTypeOfFlight(String typeOfFlight) {
		this.typeOfFlight = typeOfFlight;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	
	public LocalDate getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getFlightTitle() {
		return flightTitle;
	}

	public void setFlightTitle(String flightTitle) {
		flightTitle = flightTitle;
	}

	public String getFlightDescription() {
		return flightDescription;
	}

	public void setFlightDescription(String flightDescription) {
		flightDescription = flightDescription;
	}

	public List<Passenger> getPassengerInFlight() {
		return passengerInFlight;
	}

	public void setPassengerInFlight(List<Passenger> passengerInFlight) {
		this.passengerInFlight = passengerInFlight;
	}

	public int getPricePerPassenger() {
		return pricePerPassenger;
	}

	public void setPricePerPassenger(int pricePerPassenger) {
		pricePerPassenger = pricePerPassenger;
	}

}
