package com.ufly;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.ufly.Flight.TypeOfFlight;
import com.ufly.dao.DaoFactory;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;



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
						"2021-05-04 13:30",
						"2021-05-04 18:30",
						"Fete du nouvel an",
						"Visite surprise chez Paulsy", 
						//new ArrayList<User>(Arrays.asList(new User(1), 
						//										new User(2))),
						10,
						"images/pic01.jpg",
						1
						),
				new Flight(
						new Aircraft(),
						TypeOfFlight.ONE_WAY_TICKET,
						"Paris",
						"Chamonix",
						LocalTime.of(1,30),
						"2021-03-15 13:30",
						"2021-03-15 15:30",
						"Voyage sportif",
						"Decouverte du ski avec Paulsy", 
						12,
						"images/pic02.jpg",
						2
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
						"images/pic03.jpg",
						1
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
		
		//DaoFactory.getUserDao().becomePilot(0);
		//DaoFactory.getUserDao().becomePilot(1);
	
		PersistenceManager pm;
		Transaction tx;
		PilotInfos pi = new PilotInfos(1);

		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(pi);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		DaoFactory.getPilotDao().getPilotInfos(1);
		
	}
	
	private void generateBooking() {

		PersistenceManager pm;
		Transaction tx;
		User u;
		
		Booking b1 = new Booking(1, 1, 2, LocalDateTime.of(2021, Month.MAY, 5, 10, 0, 30).toString());
		b1.setValidated(true);
		Booking b2 = new Booking(2, 2, 2, LocalDateTime.of(2021, Month.MAY, 5, 10, 0, 30).toString());
		
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(b1);
			pm.makePersistent(b2);
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
		this.generateBooking();
	}

	public void sendMail(Booking b) {
		
		User u = DaoFactory.getUserDao().getInfosFromUser(b.getUserID());
		Flight f = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID());
		
	    Properties props = new Properties();
	    props.put("mail.smtp.user", "ufly_eidd@outlook.com");
	    props.put("mail.smtp.host", "smtp-mail.outlook.com");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.auth", "true");
	
	    try
	    {
	    Authenticator auth = new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("ufly_eidd@outlook.com", "choco0234xx");
	        }
	      };
	
	    Session session = Session.getInstance(props, auth);
	
	    MimeMessage msg = new MimeMessage(session);
	    msg.setText("Bonjour "+ u.getFirstName() + ",\n\nVotre vol ");
	    
	    msg.setSubject("Rappel Ufly - Votre réservation ");
	    msg.setFrom(new InternetAddress("ufly_eidd@outlook.com"));
	    msg.addRecipient(Message.RecipientType.TO, new InternetAddress("paulagopian94@gmail.com"));
	    Transport.send(msg);
	
	    }catch (MessagingException mex) {
	       mex.printStackTrace();
	    }	
	}

	public void sendReminderMails() {
		
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
		
		System.out.println("Sending reminder mails...");
		
		for(Booking b:blist) {
			

			if(b.isValidated()) {
				

				LocalDateTime from = LocalDateTime.now();
		        LocalDateTime fromTemp = LocalDateTime.from(from);
		        
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		        String toStr = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID()).getDepartureDate();
				LocalDateTime to = LocalDateTime.parse(toStr, formatter);
				
		        long hours = fromTemp.until(to, ChronoUnit.HOURS);
		        
		        System.out.println(hours);
		        if(hours<0) {
		        	DaoFactory.getFlightDao().deleteAFlight(b.getFlightID());
		        }
		        else if(hours < 24) {
		        	sendMail(b);
		        }
		        	
				
			}
		}

	}
	
	
	public void test() {
		
		System.out.println("hello");
	}
		

}
