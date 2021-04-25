package com.ufly.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ufly.Flight;
import com.ufly.GenerateData;
import com.ufly.ws.FlightWS;
import com.ufly.ws.FlightWS.SearchCriteria;

public class FlightDAOTest {

	@Test
	public void testGetFlightsFromCriteria() {
		GenerateData g = new GenerateData();
		g.generateAll();

		FlightWS.SearchCriteria sc = new SearchCriteria();
		sc.plane = "Cessna 172";
		sc.price = "50";
		sc.destination = "Amsterdam";
		sc.seats = 0;
		
		List<Flight> lf = DaoFactory.getFlightDao().getFlightsFromCriteria(sc);
		assertTrue(lf.size()==1);
		//System.out.println(lf.get(0).getFlightID());
		assertTrue(lf.get(0).getAircraft().getAircraftModel().equals("Cessna 172"));
        //assertThrows(IllegalStateException.class, () -> { i.remove(); } );
        
	}

	@Test
	public void testGetInfoFromAFlight() {
		//System.out.println(DaoFactory.getFlightDao().getInfoFromAFlight(1).getFlightID());
		//assertTrue(DaoFactory.getFlightDao().getInfoFromAFlight(1).getFlightID()==1);

	}

	@Test
	public void testGetAircraftInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAFlight() {
		fail("Not yet implemented");
	}

}
