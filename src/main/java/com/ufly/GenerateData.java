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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
	
	
	/* The class which periodically check for sending reminder mails  */
	class ThreadMail extends Thread {
	    public void run()
	    {
	        try {
	    		sendAllReminderMails();

	        }
	        catch (Exception e) {
	            System.out.println(e.getStackTrace());
	        }
	    }
	}
	 
	
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
		
		List<Flight> flights;
		flights = new ArrayList<Flight>();
		
		Flight f1 =	new Flight(
						"Cessna 172",
						4,
						TypeOfFlight.ROUND_TRIP,
						"Paris",
						"Amsterdam",
						LocalTime.of(1,30),
						"2021-05-05 13:30",
						"2021-05-05 18:30",
						"Fete du nouvel an",
						"Visite surprise chez Paulsy", 
						//new ArrayList<User>(Arrays.asList(new User(1), 
						//										new User(2))),
						10,
						"images/pic01.jpg",
						1
						);
		Flight f2 =	new Flight(
						"Piper PA28",
						3,
						TypeOfFlight.ONE_WAY_TICKET,
						"Paris",
						"Chamonix",
						LocalTime.of(1,30),
						"2021-06-15 13:30",
						"2021-06-15 15:30",
						"Voyage sportif",
						"Decouverte du ski avec Paulsy", 
						12,
						"images/pic02.jpg",
						2
						);
		Flight f3 =	new Flight(
						"Robin DR400 - 100HP",
						3,
						TypeOfFlight.BALLAD,
						"Volcan Volvic",
						"Volcan Volvic",
						LocalTime.of(1,30),
						"2021-07-20 14:30",
						"2021-07-20 17:30",
						"Survoler l'auvergne",
						"Visite aerienne des volcan de Volvic", 
						14,
						"images/pic03.jpg",
						1
						);
		
		flights.add(f1);
		flights.add(f2);
		flights.add(f3);
		

			
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);

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
		User passenger;
		
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

	
	
	/********************** MAILS ********************/
	


	public static void sendMail(String message, String subject, List<String> recipientList) {

	
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
	    msg.setText(message);
	   
	    msg.setSubject(subject);
	    msg.setFrom(new InternetAddress("ufly_eidd@outlook.com"));
	    
	    // for the tests, we send a mail to a default address
	    for (String s : recipientList)
	    	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
	    
	    Transport.send(msg);
	
	    }catch (MessagingException mex) {
	       mex.printStackTrace();
	    }	
	}
	
	
	public static void refuseDemand(Booking b) {
		
		User passenger = DaoFactory.getUserDao().getInfosFromUser(b.getUserID());
		Flight f = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID());
		User pilot = DaoFactory.getUserDao().getInfosFromUser(f.getPilotID());
		
		
		String message = "Bonjour "+ passenger.getFirstName() + ",\n\n"
						    + "Malheureusement, " + pilot.getFirstName() 
						    + " a refusé votre demande de réservation pour voler à bord de son avion."
			    			+ "N'hésitez pas à consulter notre site pour trouver "
			    			+ "d'autres vol partant de " + f.getDepartureAirdrome()
			    			+ "\n\nAu plaisir de vous revoir, \n\n L'équipe Ufly.";
		
		String subject = "Demande de réservation - Ufly";
	    List<String> recipientList = new ArrayList<String>();
	    recipientList.add("paulagopian94@gmail.com");
	    
	    sendMail(message, subject, recipientList);
		
		
	}
	
	
	public static void sendConfirmationMailToPassenger(Booking b) {
		
		User passenger = DaoFactory.getUserDao().getInfosFromUser(b.getUserID());
		Flight f = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID());
		User pilot = DaoFactory.getUserDao().getInfosFromUser(f.getPilotID());
		
		
		String message = "Bonjour "+ passenger.getFirstName() + ",\n\n"
						  + pilot.getFirstName() + " a accepté votre demande pour voler à bord de son avion !"
			    			+ "Vous trouverez ci-dessous les informations liées au vol:"
			    			+ "\nDate: " + f.getDepartureDate()
			    			+ "\nAérodrome de départ: " + f.getDepartureAirdrome()
			    			+ "\nDescription du vol" + f.getFlightDescription()
			    			+ "\nAvion: " + f.getAircraft()
			    			+ "\nNombre de place(s) réservée(s): " + b.getNbSeats()
			    			+ "\nPilote: "+ pilot.getFirstName() + " " + pilot.getFirstName()
			    			+ "\n\nPour toute information complémentaire concernant le vol, "
			    			+ "vous pouvez joindre " + pilot.getFirstName() + " au numéro suivant: " + pilot.getPhoneNumber()
			    			+ "\n\nBon vol ! \n\n L'équipe Ufly.";
		
		String subject = "Demande de réservation - Ufly";
	    List<String> recipientList = new ArrayList<String>();
	    recipientList.add("paulagopian94@gmail.com");
	    
	    sendMail(message, subject, recipientList);
		
		
	}
	
	
	public static void askConfirmationToPilot(Booking b) {

		User passenger = DaoFactory.getUserDao().getInfosFromUser(b.getUserID());
		Flight f = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID());
		User pilot = DaoFactory.getUserDao().getInfosFromUser(f.getPilotID());
		
		
		String message = "Bonjour "+ pilot.getFirstName() + ",\n\n"
						  + passenger.getFirstName() + " " + passenger.getLastName()
						  + " aimerait réservé " + b.getNbSeats() + " places pour le vol "
						  + f.getFlightTitle() + ".\n\n"
						  + "Veuillez renseigner si vous acceptez ou refusez cette réservation "
						  + "à l'adresse suivante: \n\n" + "http://localhost:8080/pilotConfirm.html?bookingId="+b.getBookingID()
						  + "\n\nA bientôt !\n\n L'équipe Ufly.";
		
		String subject = "Demande de réservation - Ufly";
	    List<String> recipientList = new ArrayList<String>();
	    recipientList.add("paulagopian94@gmail.com");
	    //recipientList.add("rodriguez.clement99@gmail.com");
	    
	    sendMail(message, subject, recipientList);
		
	}

	
	
	public void sendOneReminderMail(Booking b) {
		
		User passenger = DaoFactory.getUserDao().getInfosFromUser(b.getUserID());
		Flight f = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID());
		User pilot = DaoFactory.getUserDao().getInfosFromUser(f.getPilotID());
		
	    String message = "Bonjour "+ passenger.getFirstName() 
		    			+ ",\n\nVotre vol "+ f.getFlightTitle() + "aura lieu demain !"
		    			+ "Vous trouverez ci-dessous un rappel des informations liées au vol:"
		    			+ "\nPilote: "+ pilot.getFirstName() + " " + pilot.getFirstName()
		    			+ "\nHeure du départ: " + f.getDepartureDate()
		    			+ "\nAérodrome de départ: " + f.getDepartureAirdrome()
		    			+ "\nDescription du vol" + f.getFlightDescription()
		    			+ "\nAvion: " + f.getAircraft()
		    			+ "\n\nBon vol ! \n\n L'équipe Ufly.";
	   
	    String subject = "Rappel Ufly - Votre vol ";
	    
	    List<String> recipientList = new ArrayList<String>();
	    recipientList.add("paulagopian94@gmail.com");
	    recipientList.add("rodriguez.clement99@gmail.com");
	    //recipientList.add(passenger.getMail());
	    //recipientList.add(pilot.getMail());
	    
	    sendMail(message, subject, recipientList);

	}
	
	public static long getHoursDelay(String toStr, String from) {
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fromTemp = LocalDateTime.from(LocalDateTime.parse(from, formatter));
		LocalDateTime to = LocalDateTime.parse(toStr, formatter);
		
        long hours = fromTemp.until(to, ChronoUnit.HOURS);
        
        System.out.println(hours);
        
        return hours;
	}

	public void sendAllReminderMails() {
		
		long hours;
		List<Booking> blist = DaoFactory.getBookingDao().getAllBooking();
		
		for(Booking b:blist)
			askConfirmationToPilot(b);
		
		System.out.println("Sending reminder mails...");
		
		
		for(Booking b:blist) {
			
			if(b.isValidated()) {
				
		        String toStr = DaoFactory.getFlightDao().getInfoFromAFlight(b.getFlightID()).getDepartureDate();
		        LocalDateTime now = LocalDateTime.now(); 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		        String from = now.format(formatter);
		        hours = getHoursDelay(toStr, from);
		        
		        // we delete the booking for the past flights
		        if(hours < 0) {
					System.out.print("booking "+ b.getBookingID() + "has been deleted");
		        	DaoFactory.getBookingDao().deleteAbooking(b.getBookingID());
		        }
		        else if(hours < 24) {
		        	sendOneReminderMail(b);
		        }	
			
			}
		}

	}
	
	public void deleteOldFlights() {
		
		long hours;
		List<Flight> flist = DaoFactory.getFlightDao().getAllFlights();
		
		System.out.println("Deleting past flights...");
		
		
		for(Flight f:flist) {
							
	        String toStr = f.getDepartureDate();
	        LocalDateTime now = LocalDateTime.now(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        String from = now.format(formatter);
	        
	        hours = getHoursDelay(toStr, from);
	        
	        // past flight are deleted
	        if(hours<0) {
				System.out.print("flight "+ f.getFlightID() + "has been deleted");
	        	DaoFactory.getFlightDao().deleteAFlight(f.getFlightID());
	        }

		}
		
		
	}
	
	public void manageDatabase() {
		
		
		PersistenceManager pm;
		Transaction tx;
		
		generateAll();
		
		List<Flight> flist = DaoFactory.getFlightDao().getAllFlights();
		for(Flight f:flist)
			System.out.println(f.getAircraft());
		
		
		//reminder mails:
	
		// at the server start:
		sendAllReminderMails();
		
		//and each hour:
		ThreadMail t = new ThreadMail();		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(t, 1, 1, TimeUnit.HOURS);
		
		
		deleteOldFlights();
		

			
	}



}
