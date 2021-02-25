package com.example.jetty_jersey.dao;

import java.util.List;

import com.example.jetty_jersey.dao.Aircraft;

public class DAO implements PassengerDao, PilotDao, FlightDao, AircraftDao {

	public List<Flight> getFlightsFromCriteria(Aircraft aircraft, int price, String destination, int nbOfSeats) {

		
		return null;
	}

	public Flight getInfoFromAFlight(int idFlight) {
		// TODO Auto-generated method stub
		return null;
	}

	public Aircraft getAircraftInfo(int aircraftID) {
		
		String info ="Info about Aircraft n°"+aircraftID+": ...";
		// fonction qui renvoie les infos de l'avion correspondant à AircraftID
		// on part du principe qu'elle renvoie un Aircraft, on va en créer un par defaut pour faire le test
		return new Aircraft(aircraftID);
	}

	public void deleteAFlight(int idFlight) {
		// TODO Auto-generated method stub

	}

	public void sendReminderEmail(int idFlight) {
		// TODO Auto-generated method stub

	}

	public List<Flight> getPilotedFlightsList(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAFlight(int idUser) {
		// TODO Auto-generated method stub

	}

	public void editAFlight(int idUser, int idFlight) {
		// TODO Auto-generated method stub

	}

	public void CreateANewUser() {
		// TODO Auto-generated method stub

	}

	public Passenger GetInfosFromUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public void EditUserInfos(int idUser) {
		// TODO Auto-generated method stub

	}

	public void bookAFlight(int idFlight, int nbBookedSeats) {
		// TODO Auto-generated method stub

	}

	public void noteAPilot(int idUser) {
		// TODO Auto-generated method stub

	}

	public List<Flight> getFlightsList(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
