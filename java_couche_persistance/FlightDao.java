package com.example.jetty_jersey.dao;

import java.util.List;

public interface FlightDao {


	/**
	 * get a list of flights based on certain criteria
	 * @GET
	 */
	List<Flight> getFlightsFromCriteria(Aircraft aircraft, int price, String destination, int nbOfSeats);

	/**
	 * get infos from a specific flight (with the id)
	 * @GET
	 */
	Flight getInfoFromAFlight(int idFlight);


	/**
	 * delete a specific flight
	 * @DELETE
	 */
	void deleteAFlight(int idFlight);

	/**
	 * Send an email to all the passengers concerned by the flight given with the id
	 * @GET
	 */
	void sendReminderEmail(int idFlight);
}
