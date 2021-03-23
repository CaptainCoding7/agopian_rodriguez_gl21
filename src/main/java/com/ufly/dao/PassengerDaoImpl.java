package com.ufly.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

import com.ufly.Flight;
import com.ufly.Passenger;


@PersistenceCapable
public class PassengerDaoImpl implements PassengerDao {
	

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
		FlightList.add(new Flight());
		FlightList.add(new Flight());
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
