package com.ufly.dao;

import java.util.List;

import com.ufly.Flight;
import com.ufly.PilotInfos;
import com.ufly.ws.PilotWS.AddingFlightStructure;

public interface PilotDao{

	/**
	 * Get the list of flights for which the pilot is concerned AS A PILOT
	 * GET
	 */
	List<Flight> getPilotedFlightsList(int idUser);	

	/**
	 * Add a new flight (linked with a pilot designated by his id)
	 * PUT
	 */
	void addAFlight(Flight flight);


		/**
	 * Edit a specific flight
	 * POST
	 */
	void editAFlight(int idUser, int flightID);


	/**
	 * Get pilot infos from a user ID
	 * GET
	 */
	PilotInfos getPilotInfos(int userID);
}
