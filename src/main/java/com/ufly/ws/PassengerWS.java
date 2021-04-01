package com.ufly.ws;

import java.util.ArrayList;
import java.util.Arrays;

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


@Path("passenger")
public class PassengerWS {

	
	public static class IdContainer {
		public int id;
	}

	/* PASSENGER ***********************/
	
	
	/**
	 * 
	 * @param instance
	 * @return
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("createuser")
	public void createANewUser(IdContainer instance) {
		ArrayList<Passenger> passengerList=new ArrayList<Passenger>(Arrays.asList(new Passenger(),new Passenger(),new Passenger()));
		passengerList.add(new Passenger());
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("getuserinfo")
	public Passenger getInfosFromUser(IdContainer instance) {
		ArrayList<Passenger> passengerList=new ArrayList<Passenger>(Arrays.asList(new Passenger(),new Passenger(),new Passenger()));
		for(Passenger p:passengerList){
			if(p.getUserID()==instance.id)
				return p;
			}
		return null;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("edituser")
	public void editUserInfos(IdContainer instance) {
/*
		ArrayList<Passenger> passengerList=new ArrayList<Passenger>(Arrays.asList(new Passenger(1),new Passenger(2),new Passenger(3)));
		for(Passenger p:passengerList){
			if(p.getUserID()==id) {
				p.setFirstName("Lucas");
				System.out.println("edit user: ");
				System.out.println(p.getUserID());
			}
		}
		*/
		System.out.println("edit user");
		System.out.println(instance.id);
		
	}
	/**
	 * 
	 * @param instance: id du flight
	 * @param instance2: nb de places reservées
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("notepilot")
	public void noteAPilot(IdContainer instance) {
		System.out.println("note pilot "+instance.id);	
	}	

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("book")
	public void bookAFlight(IdContainer instance) {//, IdContainer instance2) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(),new Flight(),new Flight()));
		for(Flight f:flightsList){
			if(f.getFlightID()==instance.id){
				System.out.println(instance.id);
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
	@Path("passengerflightslist")
	public ArrayList<Flight> getFlightsList(IdContainer instance) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(),new Flight(),new Flight()));
		return flightsList;
	}
		
	
	
}
