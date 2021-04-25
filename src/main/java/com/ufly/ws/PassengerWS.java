package com.ufly.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ufly.Flight;
import com.ufly.Passenger;
import com.ufly.dao.DaoFactory;


@Path("passenger")
public class PassengerWS {


	/* PASSENGER ***********************/
	
	
	/**
	 * 
	 * @param instance
	 * @return
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("createuser")
	public void createANewUser(Passenger passenger) {
		DaoFactory.getPassengerDao().createANewUser(passenger);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("getuserinfo/{id}")
	public Passenger getInfosFromUser(@PathParam("id") int id) {
		return DaoFactory.getPassengerDao().getInfosFromUser(id);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("edituser/{id}")
	public void editUserInfos(@PathParam("id") int id) {
		
		
	}
	/**
	 * 
	 * @param instance: id du flight
	 * @param instance2: nb de places reservées
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("notepilot/{id}")
	public void noteAPilot(@PathParam("id") int id) {
		System.out.println("note pilot "+id);	
	}	

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("book/{id}")
	public void bookAFlight(@PathParam("id") int id) {//, IdContainer instance2) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(),new Flight(),new Flight()));
		for(Flight f:flightsList){
			if(f.getFlightID()==id){
				System.out.println(id);
				//f.setAvailableSeats(f.getAvailableSeats()-Integer.parseInt(instance2.id));
				break;
			}
		}
	}	
	
	/**
	 * Take the id of the user and return the list of the flights for which he's concerned AS A PASSENGER
	 * @param instance
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("passengerflightslist/{id}")
	public List<Flight> getFlightsList(@PathParam("id") int id) {
		return DaoFactory.getPassengerDao().getFlightsList(id);
	}
		
	
	
}
