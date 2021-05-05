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
import com.ufly.PilotInfos;
import com.ufly.User;
import com.ufly.dao.DaoFactory;


@Path("user")
public class UserWS {

	public static class LoginInfo{
		public String email;
		public String pwd;
	}
	
	public static class BookingStructure{
		public long flightID;
		public long userID;
		public int nbSeats;
	
	}
	
	/**
	 * 
	 * @param instance
	 * @return
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("createuser")
	public Boolean createANewUser(User user) {
		return DaoFactory.getUserDao().createANewUser(user);
		
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("getuserinfo/{id}")
	public User getInfosFromUser(@PathParam("id") long id) {
		return DaoFactory.getUserDao().getInfosFromUser(id);
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
	@Path("book")
	public void bookAFlight(BookingStructure bs) {//, IdContainer instance2) {
		DaoFactory.getUserDao().bookAFlight(bs.flightID, bs.userID, bs.nbSeats);
		
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
		return DaoFactory.getUserDao().getFlightsList(id);
	}
		
	
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("login")
	public User login(LoginInfo li) {

		return DaoFactory.getUserDao().login(li);
	}	

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("becomePilot")
	public PilotInfos becomePilot(long userID)  {
		PilotInfos p =  DaoFactory.getUserDao().becomePilot(userID);
		System.out.print(getInfosFromUser(userID).getIsApilot());
		return p;
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("isApilot")
	public boolean isAPilot(long userID)  {
		return DaoFactory.getUserDao().getInfosFromUser(userID).getIsApilot();
	}	


	
}
