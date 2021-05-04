package com.ufly.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.PersistenceCapable;

import com.ufly.Booking;
import com.ufly.Flight;
import com.ufly.PilotInfos;
import com.ufly.User;
import com.ufly.ws.UserWS.LoginInfo;


@PersistenceCapable
public class UserDaoImpl implements UserDao {
	
	PersistenceManagerFactory pmf;
	
	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf=pmf;
	}
	
	public void noteAPilot(int idUser) {
		// TODO Auto-generated method stub

	}

	public List<Flight> getFlightsList(long idUser) {
		
		PersistenceManager pm;
		Transaction tx;
		User p;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			p = pm.getObjectById(User.class, idUser);
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		return p.getBookedFlightsList();
	}	

	public void bookAFlight(long idFlight, long userID, int nbBookedSeats) {
		
		PersistenceManager pm;
		Transaction tx;
		User u;
		
		Booking b = new Booking(idFlight, userID, nbBookedSeats, LocalDateTime.now().toString());
		
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(b);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		
		Flight f;
		Flight detachedFlight;
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
	    tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, idFlight);
			f.setAvailableSeats(f.getAvailableSeats()-nbBookedSeats);
			tx.commit();
			
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}

	}
		


	public Boolean createANewUser(User user) {
		
		
		PersistenceManager pm;
		Transaction tx;
		List<User> uList;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soient gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			
			Query q = pm.newQuery(User.class);
			uList= (List<User>) q.execute();
			
			System.out.println(uList);
		 
			tx.commit();
		}
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			
		}
		
		for(User u : uList) {
			if(u.getMail().equals(user.getMail())) {
				System.out.println("The user "+user.getMail()+" already exists");
				return false;
			}
		}
		

		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);
		
		try {
			tx.begin();			
			pm.makePersistent(user);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		printUser(getInfosFromUser(11));
		
		return true;

	}
	
	public User getInfosFromUser(long idUser) {
		
		PersistenceManager pm;
		Transaction tx;
		User u;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			u = pm.getObjectById(User.class, idUser);
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		//System.out.println(p.getFirstName());
		
		return u;
	}	

	public void editUserInfos(int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(LoginInfo li) {
		
		PersistenceManager pm;
		Transaction tx;
		List<User> pList;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
		
			//printUser(getInfosFromUser(11));
			
			Query q = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE mail == '" + li.email +"' && pwd == '"+ li.pwd+"'");
			//Query q = pm.newQuery(User.class);
			pList= (List<User>) q.execute();
			
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
	
		for(User pl:pList)
			System.out.println(pl.getMail()+pl.getFirstName());
		
		if(pList.size()==1) {
			System.out.println("User "+pList.get(0).getMail()+" is logged");
			return pList.get(0);
		}
		System.out.println("No such user in the database");
		return null;
	}

	@Override
	public PilotInfos becomePilot(long userID) {

		PersistenceManager pm;
		Transaction tx;
		User u;
		
		// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			u = pm.getObjectById(User.class, userID);
			u.setIsApilot(true);
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		
		PilotInfos pilotInfos = new PilotInfos(userID);
		
		System.out.print(u.getIsApilot());
		// save
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(pilotInfos);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		
		return pilotInfos;
	}

	
	/**
	 * Fonction to print user attributes (test)
	 */
	void printUser(User user) {
		System.out.println("Firstname: "+user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getIsApilot());
		System.out.println(user.getMail());
		System.out.println(user.getPwd());
		System.out.println(user.getPhoneNumber());
		System.out.println(user.getLivingLocation());
		System.out.println(user.getUserID());
		System.out.println(user.getBookedFlightsList());
		System.out.println(user.getBirthday());
		
		
	}

}
