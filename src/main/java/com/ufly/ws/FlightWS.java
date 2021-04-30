package com.ufly.ws;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ufly.Aircraft;
import com.ufly.Flight;
import com.ufly.User;
import com.ufly.dao.*;


@Path("flight")
public class FlightWS {

	
	public static class IdContainer {
		public int id;
	}
	
	public static class SearchCriteria{
		public String departure;
		public String plane;
		public String price;
		public String destination;
		public int seats;
		public String depDate;	
	}
	
	/* ne fonctionne pas avec des variables statiques */
//	public static ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight("ADC-F2"),new Flight("KDO-A6"),new Flight("UDO-G5")));
//	public static ArrayList<Aircraft> aircraftsList= new ArrayList<Aircraft>(Arrays.asList(new Aircraft("B737"),new Aircraft("A256"),new Aircraft("R2D2")));	
//	public static ArrayList<User> passengerList=new ArrayList<User>(Arrays.asList(new User(1),new User(2),new User(3)));


	/* FLIGHT ***********************/
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("flightsList")
	//public List<Flight> getFlightsFromCriteria(@PathParam("plane") String plane,@PathParam("price") int price,@PathParam("destination") String destination,@PathParam("seats") int seats) {
	public List<Flight> getFlightsFromCriteria(SearchCriteria sc) {
		List<Flight> l = DaoFactory.getFlightDao().getFlightsFromCriteria(sc);
		System.out.print(l);
		return l;
	}
	
	
	/**
	 * Recupère les infos d'un vol parmi ceux de la liste à partir d'un ID de vol 
	 * pour specifier l'instance du vol en question sur postman, on ecrit:
	 * {
	 * 		"flightID" : "ADC-F2"
	 * } 
	 * @param instance
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("flightInfo/{id}")
	public Flight getInfoFromAFlight(@PathParam("id") int id) {
		return DaoFactory.getFlightDao().getInfoFromAFlight(id);
	}
		
	/**
	 * Fonction similaire mais pour les avions
	 * @param instance
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("aircraftInfo/{id}")
	public Aircraft getAircraftInfo(@PathParam("id") int id) {
		return DaoFactory.getAircraftDao().getAircraftInfo(id);

	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("deleteflight/{id}")
	public void deleteAFlight(@PathParam("id") int id){
		DaoFactory.getFlightDao().deleteAFlight(id);
	}
	
	
}
