package com.ufly.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.PersistenceCapable;
import javax.ws.rs.WebApplicationException;

import com.ufly.Flight;
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

	public List<Flight> getFlightsList(int idUser) {
		
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

	public void bookAFlight(int idFlight, int nbBookedSeats) {
		// TODO Auto-generated method stub
		
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
		
		return true;

	}
	
	public User getInfosFromUser(int idUser) {
		
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
		//System.out.println(p.getFirstName());
		
		return p;
	}	

	public void editUserInfos(int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(LoginInfo li) {
		
		PersistenceManager pm;
		Transaction tx;
		User p;
		List<User> pList;
// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			
			Query q = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE mail == '" + li.email +"' && pwd == '"+ li.pwd+"'");
			pList= (List<User>) q.execute();
			
			tx.commit();
		} 
		
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
			
		}
		
		//for(User pl:pList)
			//System.out.println(pl.getMail()+pl.getFirstName());
		
		if(pList.size()==1) {
			System.out.println("User "+pList.get(0).getMail()+" is logged");
			return pList.get(0);
		}
		System.out.println("No such user in the database");
		return null;
	}


}
