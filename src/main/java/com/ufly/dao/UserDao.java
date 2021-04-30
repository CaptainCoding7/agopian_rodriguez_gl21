package com.ufly.dao;

import java.util.List;

import com.ufly.Flight;
import com.ufly.User;
import com.ufly.ws.UserWS.LoginInfo;

public interface UserDao {


	/**
	 * Add a new user
	 * PUT
	 */
	Boolean createANewUser(User user);

	/**
	 * Get user information
	 * GET
	 */
	User getInfosFromUser(int idUser);

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
	
	
	/**
	 * 
	 * Search the user in the database and inform its presence (boolean)
	 * POST
	 */
	User login(LoginInfo li);

}
