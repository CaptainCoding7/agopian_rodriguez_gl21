package com.ufly.dao;

import java.util.List;

import com.ufly.Flight;
import com.ufly.Passenger;

public interface PassengerDao {


	/**
	 * Add a new user
	 * PUT
	 */
	void createANewUser(Passenger passenger);

	/**
	 * Get user information
	 * GET
	 */
	Passenger getInfosFromUser(int idUser);

	/**
	 * Edit user information
	 * POST
	 */
	void editUserInfos(int idUser);

	/**
	 * Book a number of seats for a flight designated by his id 
	 * POST
	 */
	void bookAFlight(int flightID, int nbBookedSeats);


	/**
	 * Give a note for a pilot (designated by his id)
	 * POST
	 */
	void noteAPilot(int idUser);


	/**
	 * Get the list of flights for which the passenger is concerned
	 * GET
	 */
	List<Flight> getFlightsList(int idUser);

}