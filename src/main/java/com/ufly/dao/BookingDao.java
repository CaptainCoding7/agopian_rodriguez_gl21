package com.ufly.dao;

import java.util.List;

import com.ufly.Booking;

public interface BookingDao {

	void deleteAbooking(long bookingID);
	
	List<Booking> getAllBooking();
	
	Booking getInfoFromABooking(long bookingID);

	void acceptBooking(long id);

	void refuseBooking(long id);

}
