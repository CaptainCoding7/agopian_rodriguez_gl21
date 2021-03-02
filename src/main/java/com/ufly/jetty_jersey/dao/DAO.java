package com.ufly.jetty_jersey.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ufly.jetty_jersey.dao.Aircraft.TypeOfFlight;

public class DAO implements PassengerDao, PilotDao, FlightDao, AircraftDao {

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

	public Aircraft getAircraftInfo(int aircraftID) {
		
		// fonction qui renvoie les infos de l'avion correspondant � AircraftID
		// on part du principe qu'elle renvoie un Aircraft, on va en cr�er un par defaut pour faire le test
		return new Aircraft(aircraftID);
	}

	public void deleteAFlight(int idFlight) {
		System.out.println("The flight with the Id :"+idFlight+" is delete");// TODO Auto-generated method stub

	}

	public void sendReminderEmail(int idFlight) {
		System.out.println("The Reminder Email was sent for flight :"+idFlight);

	}

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
		System.out.println("A flight has been added");

	}

	public void editAFlight(int idUser, int idFlight) {
		System.out.println("A flight is editing");

	}

	public Passenger GetInfosFromUser(int idUser) {
		return new Passenger(1, 
				"Paulsy", 
				"Agopian", 
				null, 
				"118 218", 
				null, 
				"Alfortville", 
				"I love music and fly",
				null, 
				null);
	}

	public void noteAPilot(int idUser) {
		// TODO Auto-generated method stub

	}

	public List<Flight> getFlightsList(int idUser) {
		List<Flight> FlightList = new ArrayList<Flight>();
		FlightList.addAll(getFlightsFromCriteria(null, idUser, null, idUser));
		FlightList.addAll(getPilotedFlightsList(idUser));
		return FlightList;
	}

	public void bookAFlight(int idFlight, int nbBookedSeats) {
		// TODO Auto-generated method stub
		
	}


	public void createANewUser() {
		// TODO Auto-generated method stub
		
	}

	public Passenger getInfosFromUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public void editUserInfos(int idUser) {
		// TODO Auto-generated method stub
		
	}

}
