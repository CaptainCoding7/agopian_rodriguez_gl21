/**
 * 
 */
package com.ufly.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

@PersistenceCapable
public class FlightDaoImpl implements FlightDao {

	
	PersistenceManagerFactory pmf;
	
	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf=pmf;
	}	
	
	public List<Flight> getFlightsFromCriteria(String plane, int price, String destination, int nbOfSeats) {

		PersistenceManager pm;
		Transaction tx;
		List<Flight> flights = new ArrayList<Flight>(); 
		
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			Flight f;			
			/*
			Query q = pm.newQuery("SELECT MAX(flightID) FROM " + Flight.class.getName());
			int maxid=(Integer) q.execute();			
			System.out.println("max id="+maxid);
			//while((f = pm.getObjectById(Flight.class, id))!=null){
			for(int id=1; id<=maxid; id++) {
				f = pm.getObjectById(Flight.class, id);
				flights.add(f);
			}
			System.out.println("teeeeeeeest");
			*/
			Query q = pm.newQuery(Flight.class);
			flights = (List<Flight>) q.execute();
			
			for(Flight fget:flights) {
				System.out.println("flight retrieved : " + fget.getFlightDescription());
			}
			System.out.println(plane+price+destination+nbOfSeats);
			flights=flights.stream()
					.filter(p->p.getPricePerPassenger()<=price)
					.filter(p->p.getAircraft().getAircraftModel().equals(plane))
					.filter(p->p.getArrivalAirport().equals(destination))
					.filter(p->p.getAvailableSeats()>=nbOfSeats)
					.collect(Collectors.toList());
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return flights ;

	}

	public Flight getInfoFromAFlight(int idFlight) {
		
		PersistenceManager pm;
		Transaction tx;
		Flight f;
// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, idFlight);
			f.setFlightTitle("TIIIIITLLLLE");
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return f;
	}

	public void deleteAFlight(int idFlight) {
		
		PersistenceManager pm;
		Transaction tx;
		Flight f;
		List<Flight> flights = new ArrayList<Flight>(); 

// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
	    
	    getFlightsFromCriteria(null, 0, null, 0);
	    
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, idFlight);
			pm.deletePersistent(f);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		System.out.println("The flight with the Id :"+idFlight+" has been deleted");// TODO Auto-generated method stub
		
	    getFlightsFromCriteria(null, 0, null, 0);		
		
	}

	public void sendReminderEmail(int idFlight) {
		System.out.println("The Reminder Email was sent for flight :"+idFlight);

	}

}
