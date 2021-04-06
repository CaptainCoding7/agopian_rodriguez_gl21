package com.ufly.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.annotations.PersistenceCapable;

import com.ufly.Flight;
import com.ufly.Passenger;


@PersistenceCapable
public class PassengerDaoImpl implements PassengerDao {
	
	PersistenceManagerFactory pmf;
	
	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf=pmf;
	}
	
	public void noteAPilot(int idUser) {
		// TODO Auto-generated method stub

	}

	public List<Flight> getFlightsList(int idUser) {
		
		PersistenceManager pm;
		Transaction tx;
		Passenger p;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, idUser);
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return p.getPassengerFlightsList();
	}	

	public void bookAFlight(int idFlight, int nbBookedSeats) {
		// TODO Auto-generated method stub
		
	}


	public void createANewUser(Passenger passenger) {
		
		PersistenceManager pm;
		Transaction tx;

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(passenger);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}	
		
		
		
	}

	public Passenger getInfosFromUser(int idUser) {
		
		PersistenceManager pm;
		Transaction tx;
		Passenger p;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, idUser);
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return p;
	}	

	public void editUserInfos(int idUser) {
		// TODO Auto-generated method stub
		
	}


}
