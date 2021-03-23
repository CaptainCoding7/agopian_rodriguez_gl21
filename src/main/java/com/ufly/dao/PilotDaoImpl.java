/**
 * 
 */
package com.ufly.dao;

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

import com.ufly.Aircraft;
import com.ufly.Flight;
import com.ufly.Passenger;
import com.ufly.Flight.TypeOfFlight;

/**
 * @author Paul
 *
 */

public class PilotDaoImpl extends PassengerDaoImpl implements PilotDao {

	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("UFly_Objects");

	public List<Flight> getPilotedFlightsList(int idUser) {
		List<Flight> SubList = new ArrayList<Flight>(Arrays.asList(
				new Flight(new Aircraft(), TypeOfFlight.ROUND_TRIP, "Alforville", "Les Pavillons-sous-bois",
						LocalTime.of(1, 30), LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30), "Fete du nouvel an", "Visite surprise chez Paulsy",10),
				new Flight(new Aircraft(), TypeOfFlight.ONE_WAY_TICKET, "Roissy", "Chamonix", LocalTime.of(1, 30),
						LocalDateTime.of(2021, 01, 01, 0, 0), LocalDateTime.of(2021, 01, 01, 1, 30), "Voyage sportif",
						"Decouverte du ski avec Paulsy",12),
				new Flight(new Aircraft(), TypeOfFlight.BALLAD, "Volcan Volvic", "Volcan Volvic",
						LocalTime.of(1, 30), LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30), "Survoler l'auvergne",
						"Visite aerienne des volcan de Volvic",14)));
		return SubList;
	}

	public void addAFlight(int idUser) {
		
		PersistenceManager pm;
		Transaction tx;

		Flight f = new Flight();
		f.setFlightDescription("un voyage en avion trop cool");

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(f);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();

			// Query q = pm.newQuery("SELECT FROM " + Flight.class.getName() + " WHERE price
			// < 150.00 ORDER BY price ASC");
			Flight f_ret = pm.getObjectById(Flight.class, idUser);
			System.out.println("flight retrieved : " + f_ret.getFlightDescription());
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}

	public void editAFlight(int idUser, int idFlight) {
		System.out.println("A flight is editing");

	}

}
