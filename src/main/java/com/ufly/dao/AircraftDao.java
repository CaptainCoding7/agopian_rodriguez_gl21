package com.ufly.dao;

import com.ufly.Aircraft;

public interface AircraftDao {
	
	
	/**
	 * get infos from a plane
	 * GET
	 */
	Aircraft getAircraftInfo(int aircraftID);

}
