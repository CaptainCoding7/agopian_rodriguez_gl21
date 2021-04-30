package com.ufly;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Flight {
			
	
	public enum TypeOfFlight{
		ROUND_TRIP/*A->B B->A*/, ONE_WAY_TICKET/*A->B*/, BALLAD/*A->A*/ 
	}
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int flightID;
	private Aircraft aircraft;
	private TypeOfFlight typeOfFlight;
	private String departureAirport;
	private String destination;
	private LocalTime duration;
	private String depatureDate;
	private String arrivalDate;
	
	//thing about the last date before close the booking
	
	private String flightTitle;
	private String flightDescription;
	private List<User> passengerInFlight;
	private int pricePerPassenger;
	private int availableSeats;
	private String flightImg;
	
	public Flight(Aircraft aircraft, TypeOfFlight typeOfFlight, String departureAirport, String arrivalAirport, LocalTime duration,
			String depatureDate, String arrivalDate, String flightTitle, String flightDescription, int pricePerPassenger, String flightImg) {
		//this.flightID=flightID; // auto-increment s'en occupe !
		this.aircraft = aircraft;
		this.typeOfFlight = typeOfFlight;
		this.departureAirport = departureAirport;
		this.destination = arrivalAirport;
		this.duration = duration;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
		this.flightTitle = flightTitle;
		this.flightDescription = flightDescription;
		this.availableSeats=aircraft.getSeatNumber();
		this.pricePerPassenger = pricePerPassenger;
		this.setFlightImg(flightImg);
	}
	
	public Flight()
	{
		this.aircraft = null;
		this.setAvailableSeats(0);
		this.typeOfFlight = TypeOfFlight.ROUND_TRIP;
		this.departureAirport = "";
		this.destination = "";
		this.duration = null;
		this.depatureDate = null;
		this.arrivalDate = null;
		this.flightTitle = "";
		this.flightDescription = "default flight";
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

	public TypeOfFlight getTypeOfFlight() {
		return typeOfFlight;
	}

	public void setTypeOfFlight(TypeOfFlight typeOfFlight) {
		this.typeOfFlight = typeOfFlight;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String arrivalAirport) {
		this.destination = arrivalAirport;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	
	public String getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(String departureDate) {
		this.depatureDate=departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
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

	public List<User> getPassengerInFlight() {
		return passengerInFlight;
	}

	public void setPassengerInFlight(List<User> passengerInFlight) {
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

	public String getFlightImg() {
		return flightImg;
	}

	public void setFlightImg(String flightImg) {
		this.flightImg = flightImg;
	}

}
