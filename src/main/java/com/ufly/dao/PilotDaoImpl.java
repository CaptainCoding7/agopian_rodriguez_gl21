/**
 * 
 */
package com.ufly.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
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
public class PilotDaoImpl extends PassengerDaoImpl implements PilotDao {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
	
	public List<Flight> getPilotedFlightsList(int idUser) {
		List<Flight> SubList = new ArrayList<Flight>(Arrays.asList(
				new Flight(1,
						new Aircraft(1),
						TypeOfFlight.ALLER_RETOUR,
						"Alforville",
						"Les Pavillons-sous-bois",
						LocalTime.of(1,30),
						LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30),
						"Fete du nouvel an",
						"Visite surprise chez Paulsy", 
						new ArrayList<Passenger>(Arrays.asList(new Passenger(1), 
																new Passenger(2))),
						10
						),
				new Flight(2,
						new Aircraft(2),
						TypeOfFlight.ALLER_SIMPLE,
						"Roissy",
						"Chamonix",
						LocalTime.of(1,30),
						LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30),
						"Voyage sportif",
						"Decouverte du ski avec Paulsy", 
						new ArrayList<Passenger>(Arrays.asList(new Passenger(1), 
																new Passenger(2))),
						12
						),
				new Flight(3,
						new Aircraft(3),
						TypeOfFlight.BALLADE,
						"Volcan Volvic",
						"Volcan Volvic",
						LocalTime.of(1,30),
						LocalDateTime.of(2021, 01, 01, 0, 0),
						LocalDateTime.of(2021, 01, 01, 1, 30),
						"Survoler l'auvergne",
						"Visite aerienne des volcan de Volvic", 
						new ArrayList<Passenger>(Arrays.asList(new Passenger(1), 
																new Passenger(2))),
						14
						)));
		return SubList ;
	}

	public void addAFlight(int idUser) {
		
		Flight f = new Flight(idUser);
		f.setFlightDescription("un voyage en avion trop cool");
		
		// save 
		PersistenceManager pm = pmf.getPersistenceManager();
		f = pm.makePersistent(f);
		pm.close();

		// retrieve
		PersistenceManager pm_ret = pmf.getPersistenceManager();
		Flight f_ret = pm_ret.getObjectById(Flight.class, idUser);
		pm_ret.close();
		System.out.println("flight retrieved : "+f_ret.getFlightDescription());
		
	}

	public void editAFlight(int idUser, int idFlight) {
		System.out.println("A flight is editing");

	}

	
}
