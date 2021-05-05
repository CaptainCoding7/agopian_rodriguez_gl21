package com.ufly.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.ufly.Booking;
import com.ufly.Flight;
import com.ufly.GenerateData;
import com.ufly.User;
import com.ufly.Booking;

public class BookingDaoImpl implements BookingDao {

	
	PersistenceManagerFactory pmf;
	
	public BookingDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf=pmf;
	}	
	
	
	@Override
	public void deleteAbooking(long idbooking) {

		
		PersistenceManager pm;
		Transaction tx;
		Booking b;

		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
    	    
		try {
			tx.begin();
			b = pm.getObjectById(Booking.class, idbooking);
			pm.deletePersistent(b);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		System.out.println("The booking with the Id :"+idbooking+" has been deleted");
		
	
	}
	public List<Booking> getAllBooking(){
		
		PersistenceManager pm;
		Transaction tx;
		List<Booking> blist;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			Query q = pm.newQuery(Booking.class);
			blist = (List<Booking>) q.execute();
			
			for(Booking b:blist)
				System.out.println(b.getDate());
	
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
	
			pm.close();
			
		}
		
		return blist;
		
	}
	
	
	public Booking getInfoFromABooking(long idBooking) {
		
		PersistenceManager pm;
		Transaction tx;
		Booking b;
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			b = pm.getObjectById(Booking.class, idBooking);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return b;
	}


	@Override
	public void acceptBooking(long BookingId) {
		
		PersistenceManager pm;
		Transaction tx;
		Booking b;

		// setting the boolean variable isValidated to true
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			b = pm.getObjectById(Booking.class, BookingId);
			b.setValidated(true);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		
		Flight f;
		// modifying the number of available seats
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
	    tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, b.getFlightID());
			f.setAvailableSeats(f.getAvailableSeats()-b.getNbSeats());
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		
		System.out.println("Booked !");
		
		GenerateData.sendConfirmationMailToPassenger(b);;
		
		System.out.println("Mail sent !");

	}


	@Override
	public void refuseBooking(long bookingId) {
		
		Booking b = getInfoFromABooking(bookingId);	
		GenerateData.refuseDemand(b);
		
	}
	
	
}
