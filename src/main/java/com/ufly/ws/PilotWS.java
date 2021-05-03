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
import com.ufly.dao.*;


@Path("pilot")
public class PilotWS {

	
	public static class IdContainer {
		public int id;
	}
	
	/**
	 * 
	 * @author Paul
	 * Object composed of a flight and the of the pilot
	 */
	public static class AddingFlightStructure {
		public Flight flight;
		public int idUser;
	}
	
	/* PILOT ***********************/
	
	
	/**
	 * Take the id of the user and return the list of the flights for which he's concerned AS A PILOT
	 * @param instance
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("pilotFlightsList/{id}")
	public List<Flight> getPilotedFlightsList(@PathParam("id") int id) {
		return DaoFactory.getPilotDao().getPilotedFlightsList(id);
	}
		
	/**
	 * Create a new flight for the pilot designated by his id
	 * @param instance
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("addflight")
	public void addAFlight(AddingFlightStructure as) {
		DaoFactory.getPilotDao().addAFlight(as);
		//System.out.println("new user "+instance.id);
	
	}
	
	/**
	 * Edit a flight for the pilot designated by his id
	 * @param instance
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("editflight")
	public void editAFlight(IdContainer instance) {//,IdContainer instance2) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(),new Flight(),new Flight()));
		for(Flight f:flightsList){
			if(f.getFlightID()==instance.id){
				// and if the flight is in the list of flights piloted by the user
				//System.out.print("edit the flight "+instance2.id);
				System.out.print("edit the flight _");
				System.out.println(" for the user "+instance.id+ ":");
				f.setFlightTitle("Excursion nocturne inoubliable");
				//System.out.println(instance2);
			}
		}
	}

		
	
	
}
