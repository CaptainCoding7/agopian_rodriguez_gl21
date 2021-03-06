package com.ufly.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class DaoFactory {
	
	
	// PersistenceManagerFactory
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("UFly_Objects");
	
		
	public static FlightDao getFlightDao() {
		return new FlightDaoImpl(pmf);
	}

	public static UserDao getUserDao() {
		return new UserDaoImpl(pmf);
	}
	
	public static PilotDao getPilotDao() {
		return new PilotDaoImpl(pmf);
	}

	
	public static BookingDao getBookingDao() {
		return new BookingDaoImpl(pmf);
	}
}
