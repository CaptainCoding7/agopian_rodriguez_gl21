/**
 * 
 */
package com.ufly.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.annotations.PersistenceCapable;

import com.ufly.Aircraft;
import com.ufly.Flight;

/**
 * @author Paul
 *
 */

@PersistenceCapable
public class AircraftDaoImpl implements AircraftDao {

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("UFly_Objects");
	
	public Aircraft getAircraftInfo(int aircraftID) {
		PersistenceManager pm;
		Transaction tx;
		Aircraft a;
// retrieve
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
		// retainValues pour que les attributs soit gardés
	    tx.setRetainValues(true);
		try {
			tx.begin();
			a = pm.getObjectById(Aircraft.class, aircraftID);
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

}
