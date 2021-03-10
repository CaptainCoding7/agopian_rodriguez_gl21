package com.ufly.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ufly.jetty_jersey.dao.*;

@Path("ufly")
public class WebServicesREST {

	public class TestClass {
		public int id;
	}
	
	/* ne fonctionne pas avec des variables statiques */
//	public static ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight("ADC-F2"),new Flight("KDO-A6"),new Flight("UDO-G5")));
//	public static ArrayList<Aircraft> aircraftsList= new ArrayList<Aircraft>(Arrays.asList(new Aircraft("B737"),new Aircraft("A256"),new Aircraft("R2D2")));	
//	public static ArrayList<Passenger> passengerList=new ArrayList<Passenger>(Arrays.asList(new Passenger(1),new Passenger(2),new Passenger(3)));


	/* FLIGHT ***********************/
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("flightsList")
	public ArrayList<Flight> getFlightsFromCriteria() {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
		return flightsList;
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
	@Path("flightInfo")
	public Flight getInfoFromAFlight(int instance) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
		for(Flight f:flightsList) {
			if(f.getFlightID()==instance)
				return f;
		}
		return null;
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
		ArrayList<Aircraft> aircraftsList= new ArrayList<Aircraft>(Arrays.asList(new Aircraft(1),new Aircraft(2),new Aircraft(3)));	
		for(Aircraft a:aircraftsList){
			System.out.println(a.getAircraftID());
			if(a.getAircraftID()==id)
				return a;
		}
		return null;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("deleteflight")
	public void deleteAFlight(TestClass instance){
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
		for(Flight f:flightsList){
			if(f.getFlightID()==instance.id){
				flightsList.remove(f);
				System.out.println(flightsList);
				break;
			}
		}
	}
	
	/* PILOT ***********************/
	
	
	/**
	 * Take the id of the user and return the list of the flights for which he's concerned AS A PILOT
	 * @param instance
	 * @return
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("pilotFlightsList")
	public ArrayList<Flight> getPilotedFlightsList(TestClass instance) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
		return flightsList;
	}
		
	/**
	 * Create a new flight for the pilot designated by his id
	 * @param instance
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("addflight")
	public void addAFlight(TestClass instance) {
		System.out.println(instance.id);
	}
	
	/**
	 * Edit a flight for the pilot designated by his id
	 * @param instance
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("editflight")
	public void editAFlight(TestClass instance) {//,TestClass instance2) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
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

	/* PASSENGER ***********************/
	
	
	/**
	 * 
	 * @param instance
	 * @return
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("createuser")
	public void createANewUser(TestClass instance) {
		ArrayList<Passenger> passengerList=new ArrayList<Passenger>(Arrays.asList(new Passenger(1),new Passenger(2),new Passenger(3)));
		passengerList.add(new Passenger(instance.id));
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("getuserinfo")
	public Passenger getInfosFromUser(TestClass instance) {
		ArrayList<Passenger> passengerList=new ArrayList<Passenger>(Arrays.asList(new Passenger(1),new Passenger(2),new Passenger(3)));
		for(Passenger p:passengerList){
			if(p.getUserID()==instance.id)
				return p;
			}
		return null;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("edituser")
	public void editUserInfos(TestClass instance) {
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
	public void noteAPilot(TestClass instance) {
		System.out.println("note pilot "+instance.id);	
	}	

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("book")
	public void bookAFlight(TestClass instance) {//, TestClass instance2) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
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
	public ArrayList<Flight> getFlightsList(TestClass instance) {
		ArrayList<Flight> flightsList= new ArrayList<Flight>(Arrays.asList(new Flight(1),new Flight(2),new Flight(3)));
		return flightsList;
	}
		
	
	
}
