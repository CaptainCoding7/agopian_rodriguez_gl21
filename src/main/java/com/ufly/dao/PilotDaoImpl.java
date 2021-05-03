/**
 * 
 */
package com.ufly.dao;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.PersistenceCapable;

import org.codehaus.jackson.map.ObjectMapper;

import com.ufly.Aircraft;
import com.ufly.Flight;
import com.ufly.User;
import com.ufly.ws.PilotWS.AddingFlightStructure;
import com.ufly.PilotInfos;
import com.ufly.Flight.TypeOfFlight;

/**
 * @author Paul
 *
 */

public class PilotDaoImpl implements PilotDao {

	
	PersistenceManagerFactory pmf;
	
	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf=pmf;
	}

	public List<Flight> getPilotedFlightsList(int idUser) {
		List<Flight> SubList = new ArrayList<Flight>(Arrays.asList(
				new Flight(new Aircraft(), TypeOfFlight.ROUND_TRIP, "Alforville", "Les Pavillons-sous-bois",
						LocalTime.of(1, 30), "2021-03-15 13:30", "2021-03-15 13:30", "Fete du nouvel an", "Visite surprise chez Paulsy",10,null),
				new Flight(new Aircraft(), TypeOfFlight.ONE_WAY_TICKET, "Roissy", "Chamonix", LocalTime.of(1, 30),
						"2021-03-15 13:30","2021-03-15 13:30", "Voyage sportif",
						"Decouverte du ski avec Paulsy",12,null),
				new Flight(new Aircraft(), TypeOfFlight.BALLAD, "Volcan Volvic", "Volcan Volvic",
						LocalTime.of(1, 30), "2021-03-15 13:30",
						"2021-03-15 13:30", "Survoler l'auvergne",
						"Visite aerienne des volcan de Volvic",14,null)));
		return SubList;
	}

	/**
	 * 
	 */
	public void addAFlight(AddingFlightStructure as) {
		
		PersistenceManager pm;
		Transaction tx;
		PilotInfos pilotRetrieved;
		PilotInfos detachedPilot;
		List<Flight> pilotFlightsList;

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			pilotRetrieved = pm.getObjectById(PilotInfos.class, as.idUser);
			
			detachedPilot = pm.detachCopy(pilotRetrieved);
			pilotFlightsList = detachedPilot.getPilotFlightsList();
			pilotFlightsList.add(as.flight);
			
			pilotRetrieved.setPilotFlightsList(pilotFlightsList);
			
			
			/* print of the flight */
			ObjectMapper mapper = new ObjectMapper();
			String jsonString ="";
			try {
				//Converting the Object to JSONString
				jsonString = mapper.writeValueAsString(as.flight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(jsonString);
			
			pm.makePersistent(as.flight);


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

}
