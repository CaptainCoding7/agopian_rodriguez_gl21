package com.ufly.jetty_jersey.dao;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

import com.ufly.jetty_jersey.dao.Aircraft.TypeOfFlight;

public class Flight {
			
	private int flightID;
	private Aircraft aircraft;
	private Aircraft.TypeOfFlight typeOfFlight;
	private String departureAirport;
	private String arrivalAirport;
	private LocalTime duration;
	private LocalDateTime depatureDate;
	private LocalDateTime arrivalDate;
	
	//thing about the last date before close the booking
	
	private String flightTitle;
	private String flightDescription;
	private List<Passenger> passengerInFlight;
	private int pricePerPassenger;
	private int availableSeats;
	
	public Flight(int flightID, Aircraft aircraft, Aircraft.TypeOfFlight typeOfFlight, String departureAirport, String arrivalAirport, LocalTime duration,
			LocalDateTime depatureDate, LocalDateTime arrivalDate, String flightTitle, String flightDescription,
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
		this.availableSeats=aircraft.getSeatNumber();
		this.pricePerPassenger = pricePerPassenger;
	}
	
	public Flight(int flightID)
	{
		this.flightID=flightID;
		this.aircraft = null;
		this.setAvailableSeats(0);
		this.typeOfFlight = TypeOfFlight.ALLER_RETOUR;
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

	public Aircraft.TypeOfFlight getTypeOfFlight() {
		return typeOfFlight;
	}

	public void setTypeOfFlight(Aircraft.TypeOfFlight typeOfFlight) {
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
	
	public LocalDateTime getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(LocalDateTime depatureDate) {
		this.depatureDate = depatureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getFlightTitle() {
		return flightTitle;
	}

	public void setFlightTitle(String flightTitle) {
		this.flightTitle = flightTitle;
	}

	public String getFlightDescription() {
		return flightDescription;
	}

	public void setFlightDescription(String flightDescription) {
		this.flightDescription = flightDescription;
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
		this.pricePerPassenger = pricePerPassenger;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

}
