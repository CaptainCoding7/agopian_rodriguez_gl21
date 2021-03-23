package com.ufly;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.ufly.Flight.TypeOfFlight;

/**
 * Classe pour générer des données (vols, users, pilots...) au lancement du serveur
 * @author Paul
 *
 */
public class GenerateData {
		
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("UFly_Objects");
	
	
	/**
	 * Aicrafts generation, store them in the database
	 */
	public void generateAicrafts() {
		
		
	}
	
	/**
	 * Flights generation, store them in the database
	 */
	public void generateFlights() {

		PersistenceManager pm;
		Transaction tx;

		List<Flight> flights = new ArrayList<Flight>(Arrays.asList(
				new Flight(
						new Aircraft(),
						TypeOfFlight.ROUND_TRIP,
						"Alforville",
						"Les Pavillons-sous-bois",
						LocalTime.of(1,30),
						LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30),
						"Fete du nouvel an",
						"Visite surprise chez Paulsy", 
						//new ArrayList<Passenger>(Arrays.asList(new Passenger(1), 
						//										new Passenger(2))),
						10
						),
				new Flight(
						new Aircraft(),
						TypeOfFlight.ONE_WAY_TICKET,
						"Roissy",
						"Chamonix",
						LocalTime.of(1,30),
						LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30),
						"Voyage sportif",
						"Decouverte du ski avec Paulsy", 
						12
						),
				new Flight(
						new Aircraft(),
						TypeOfFlight.BALLAD,
						"Volcan Volvic",
						"Volcan Volvic",
						LocalTime.of(1,30),
						LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30),
						"Survoler l'auvergne",
						"Visite aerienne des volcan de Volvic", 
						14
						)));
		

		

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			for(Flight f: flights) {
				pm.makePersistent(f);
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
}
