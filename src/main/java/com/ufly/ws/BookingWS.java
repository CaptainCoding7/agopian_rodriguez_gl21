package com.ufly.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ufly.Booking;
import com.ufly.dao.DaoFactory;



 @Path("booking")
public class BookingWS {

		
	 
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("bookingInfo/{id}")
	public Booking getInfoFromAbooking(@PathParam("id") long id) {
		return DaoFactory.getBookingDao().getInfoFromABooking(id);

	}
	
	
	 
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("accept/{id}")
	public void acceptBooking(@PathParam("id") long id) {
		DaoFactory.getBookingDao().acceptBooking(id);

	}	
	
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("refuse/{id}")
	public void refuseBooking(@PathParam("id") long id) {
		DaoFactory.getBookingDao().refuseBooking(id);

	}	
	
}

	
	
