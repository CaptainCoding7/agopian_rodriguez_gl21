package com.example.jetty_jersey.dao;

public interface AircraftDao {
	
	
	/**
	 * get infos from a plane
	 * @GET
	 */
	Aircraft getAircraftInfo(int aircraftID);

}
