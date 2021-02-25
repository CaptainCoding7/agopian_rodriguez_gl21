package com.example.jetty_jersey.dao;

import java.util.List;

public interface PilotDao extends PassengerDao {

	/**
	 * Get the list of flights for which the pilot is concerned AS A PILOT
	 * @GET
	 */
	List<Flight> getPilotedFlightsList(int idUser);	

	/**
	 * Add a new flight (linked with a pilot designated by his id)
	 * @PUT
	 */
	void addAFlight(int idUser);

		/**
	 * Edit a specific flight
	 * @POST
	 */
	void editAFlight(int idUser, int idFlight);

}
