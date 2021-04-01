package com.ufly;

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
		
		PersistenceManager pm;
		Transaction tx;
		List<Aircraft> aircrafts = new ArrayList<Aircraft>(Arrays.asList(new Aircraft(),new Aircraft(),new Aircraft()));
		aircrafts.get(0).setAircraftModel("Cessna 172");
		aircrafts.get(1).setAircraftModel("Piper PA28");
		aircrafts.get(2).setAircraftModel("Robin DR400 - 100HP");
		
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			for(Aircraft a: aircrafts) {
				pm.makePersistent(a);
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}
	
	public List<Aircraft> getAircraftsList(){
		
		PersistenceManager pm;
		Transaction tx;
		List<Aircraft> a;
		
		// retrieve aircraft list
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);
			a = (List<Aircraft>) q.execute();
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return a;
	}
	
	/**
	 * Flights generation, store them in the database
	 */
	public void generateFlights() {

		PersistenceManager pm;
		Transaction tx;

		List<Aircraft> aircrafts = this.getAircraftsList();
		List<Flight> flights = new ArrayList<Flight>(Arrays.asList(
				new Flight(
						aircrafts.get(0),
						TypeOfFlight.ROUND_TRIP,
						"Alforville",
						"Amsterdam",
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
	
	/**
	 * Passenger generation, store them in the database
	 */
	public void generatePassengers() {
		
		PersistenceManager pm;
		Transaction tx;
		List<Passenger> pass = new ArrayList<Passenger>(Arrays.asList(new Passenger(),new Passenger()));
		pass.get(0).setFirstName("michel");
		pass.get(1).setFirstName("jean-patrick");		
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			for(Passenger a: pass) {
				pm.makePersistent(a);
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}
	
	/**
	 * Passenger generation, store them in the database
	 */
	public void generatePilots() {
		
		PersistenceManager pm;
		Transaction tx;
		List<Pilot> pass = new ArrayList<Pilot>(Arrays.asList(new Pilot(),new Pilot(),new Pilot()));
		pass.get(0).setFirstName("michel");
		pass.get(1).setFirstName("jean-patrick");		
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			
			for(Pilot a: pass) {
				pm.makePersistent(a);
			}
			//pm.makePersistentAll(pass);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}
	
	/**
	 * Generate all the data
	 */
	public void generateAll() {
		this.generateAicrafts();
		this.generateFlights();
		this.generatePassengers();
		this.generatePilots();
	}
	
	
}
