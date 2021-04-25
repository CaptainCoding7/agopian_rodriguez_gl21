package com.ufly.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import com.ufly.Flight;
import com.ufly.GenerateData;
import com.ufly.Passenger;

public class PassengerDaoTest {

	@Test
	public void testNoteAPilot() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFlightsList() {
		fail("Not yet implemented");
	}

	@Test
	public void testBookAFlight() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateANewUser() {
		GenerateData g = new GenerateData();
		g.generateAll();
		Passenger p=new Passenger("paulagopian94@gmail.com","jhfz6ef","Paul", "Agopian","0782653889","Alf",null,"1999-04-19");
		DaoFactory.getPassengerDao().createANewUser(p);
		p=new Passenger("pau94@gmail.com","jhfz6ef","lucas", "Agopian","0782653889","Alf",null,"1999-04-19");
		DaoFactory.getPassengerDao().createANewUser(p);	
		//--------------- retrieve test : get the new table of passengers from the database
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("UFly_Objects");
		PersistenceManager pm;
		Transaction tx;
		List<Passenger> lp = new ArrayList<Passenger>(); 

		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			Passenger pa;
			Query q = pm.newQuery(Passenger.class);
			lp = (List<Passenger>) q.execute();
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		for(Passenger pget : lp)
			System.out.println(pget.getFirstName()+pget.getUserID());
		assertTrue(lp.get(0).getFirstName().equals("Paul"));
		assertTrue(lp.get(0).getMail().equals("paulagopian94@gmail.com"));

		//------------------------
		
	
	}

	@Test
	public void testGetInfosFromUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUserInfos() {
		fail("Not yet implemented");
	}

}
