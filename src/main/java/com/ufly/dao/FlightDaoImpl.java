/**
 * 
 */
package com.ufly.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ufly.Aircraft;
import com.ufly.Flight;
import com.ufly.Passenger;
import com.ufly.Flight.TypeOfFlight;

/**
 * @author Paul
 *
 */
public class FlightDaoImpl implements FlightDao {

	public List<Flight> getFlightsFromCriteria(Aircraft aircraft, int price, String destination, int nbOfSeats) {

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

	public Flight getInfoFromAFlight(int idFlight) {
		return new Flight(idFlight,
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
				);
	}


	public void deleteAFlight(int idFlight) {
		System.out.println("The flight with the Id :"+idFlight+" is delete");// TODO Auto-generated method stub

	}

	public void sendReminderEmail(int idFlight) {
		System.out.println("The Reminder Email was sent for flight :"+idFlight);

	}

}
