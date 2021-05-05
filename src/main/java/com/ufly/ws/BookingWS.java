package com.ufly.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ufly.Aircraft;
import com.ufly.Booking;
import com.ufly.Flight;
import com.ufly.dao.DaoFactory;
import com.ufly.ws.FlightWS.SearchCriteria;



 @Path("booking")
public class BookingWS {

		
	 
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("bookingInfo/{id}")
	public Booking getInfoFromAbooking(@PathParam("id") long id) {
		return DaoFactory.getBookingDao().getInfoFromABooking(id);

	}
	
	
	 
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("accept/{id}")
	public void acceptBooking(@PathParam("id") long id) {
		DaoFactory.getBookingDao().acceptBooking(id);

	}	
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("refuse/{id}")
	public void refuseBooking(@PathParam("id") long id) {
		DaoFactory.getBookingDao().refuseBooking(id);

	}	
	
}

	
	
