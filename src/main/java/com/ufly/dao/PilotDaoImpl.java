/**
 * 
 */
package com.ufly.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import org.codehaus.jackson.map.ObjectMapper;

import com.ufly.Flight;
import com.ufly.GenerateData;
import com.ufly.PilotInfos;

/**
 * @author Paul
 *
 */

public class PilotDaoImpl implements PilotDao {

	
	PersistenceManagerFactory pmf;
	
	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf=pmf;
	}


	/**
	 * 
	 */
	public void addAFlight(Flight flight) {
		
		PersistenceManager pm;
		Transaction tx;
		PilotInfos pilotRetrieved;
		PilotInfos detachedPilot;
		List<Flight> pilotFlightsList;
		
		String departureDate = flight.getDepartureDate();
		String arrivalDate = flight.getArrivalDate();
		flight.setDepartureDate(departureDate.replace("T", " "));
		flight.setArrivalDate(arrivalDate.replace("T", " "));
		
		flight.setDuration(GenerateData.getHoursDelay(flight.getArrivalDate(),flight.getDepartureDate()));

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			
			pilotRetrieved = pm.getObjectById(PilotInfos.class, flight.getPilotID());
			
			detachedPilot = pm.detachCopy(pilotRetrieved);
			pilotFlightsList = detachedPilot.getPilotFlightsList();
			pilotFlightsList.add(flight);
			
			pilotRetrieved.setPilotFlightsList(pilotFlightsList);
			
			
			//as.flight.setPilotID(as.idUser);
			/* print of the flight */

			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString ="";
			try {
				//Converting the Object to JSONString
				jsonString = mapper.writeValueAsString(flight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(jsonString);
			
			pm.makePersistent(flight);
			
			try {
				//Converting the Object to JSONString
				jsonString = mapper.writeValueAsString(flight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(jsonString);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
/*
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Query q = pm.newQuery(Flight.class);
			List<Flight> flights = (List<Flight>) q.execute();
			//for
			//System.out.println("flight retrieved : " + f_ret.getFlightDescription());
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
*/
	}

	public void editAFlight(int idUser, int idFlight) {
		System.out.println("A flight is editing");

	}

	@Override
	public PilotInfos getPilotInfos(int userID) {
		
		PersistenceManager pm;
		Transaction tx;
		PilotInfos pi;
		List<PilotInfos> pl = new ArrayList<PilotInfos>();
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gard�s
	    tx.setRetainValues(true);
		try {
			tx.begin();
			//Query q = pm.newQuery(PilotInfos.class);
			//pl = (List<PilotInfos>) q.execute();
	
			pi = pm.getObjectById(PilotInfos.class, userID);
			tx.commit();
		} 
	
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		
		return pi;
	}

	@Override
	public List<Flight> getPilotedFlightsList(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
