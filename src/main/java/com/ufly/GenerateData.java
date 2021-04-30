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
		List<Flight> flights;
		flights = new ArrayList<Flight>(Arrays.asList(
				new Flight(
						aircrafts.get(0),
						TypeOfFlight.ROUND_TRIP,
						"Paris",
						"Amsterdam",
						LocalTime.of(1,30),
						"2021-05-26 13:30",
						"2021-05-26 18:30",
						"Fete du nouvel an",
						"Visite surprise chez Paulsy", 
						//new ArrayList<User>(Arrays.asList(new User(1), 
						//										new User(2))),
						10,
						"images/pic01.jpg"
						),
				new Flight(
						new Aircraft(),
						TypeOfFlight.ONE_WAY_TICKET,
						"Roissy",
						"Chamonix",
						LocalTime.of(1,30),
						"2021-03-15 13:30",
						"2021-03-15 15:30",
						"Voyage sportif",
						"Decouverte du ski avec Paulsy", 
						12,
						"images/pic02.jpg"
						),
				new Flight(
						new Aircraft(),
						TypeOfFlight.BALLAD,
						"Volcan Volvic",
						"Volcan Volvic",
						LocalTime.of(1,30),
						"2021-04-20 14:30",
						"2021-04-20 17:30",
						"Survoler l'auvergne",
						"Visite aerienne des volcan de Volvic", 
						14,
						"images/pic03.jpg"
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
	 * User generation, store them in the database
	 */
	public void generateUsers() {
		
		PersistenceManager pm;
		Transaction tx;
		List<User> pass = new ArrayList<User>(Arrays.asList(new User(),new User()));
		pass.get(0).setFirstName("michel");
		pass.get(0).setMail("michel@gmail.com");
		pass.get(0).setPwd("xxx");
		pass.get(1).setFirstName("jean-patrick");	
		pass.get(1).setMail("jp@gmail.com");

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			for(User a: pass) {
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
	 * User generation, store them in the database
	 */
	public void generatePilots() {
		
		PersistenceManager pm;
		Transaction tx;
		List<Pilot> pass = new ArrayList<Pilot>(Arrays.asList(new Pilot(),new Pilot()));
		pass.get(0).setFirstName("benoit");
		pass.get(0).setMail("b@");
		pass.get(1).setFirstName("toto");
		pass.get(1).setMail("t@");
		
	
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
		this.generateUsers();
		this.generatePilots();
	}
	
	
}
