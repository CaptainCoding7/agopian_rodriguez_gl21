package com.ufly.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class DaoFactory {
	
	
	// PersistenceManagerFactory
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("UFly_Objects");
	
	
	public static AircraftDao getAircraftDao() {
		return new AircraftDaoImpl(pmf);
	}
	
	public static FlightDao getFlightDao() {
		return new FlightDaoImpl(pmf);
	}

	public static PassengerDao getPassengerDao() {
		return new PassengerDaoImpl(pmf);
	}
	
	public static PilotDao getPilotDao() {
		return new PilotDaoImpl(pmf);
	}
		
}
