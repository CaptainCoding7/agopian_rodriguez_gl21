package Business_Objects;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Flight {
	
	private class Plane {
		private int planeID;
		private String planeModel;
		private String owner;
		private String registration;
		private int seatNumber;
		private int flightHours;
		private int rentingPrice;
		private Image picture;
		
		public Plane(int planeID,String planeModel, String owner, String registration,
				int seatNumber, int flightHours, int rentingPrice, Image picture) {
			this.planeID=planeID;
			this.planeModel = planeModel;
			this.owner = owner;
			this.registration = registration;
			this.seatNumber = seatNumber;
			this.flightHours = flightHours;
			this.rentingPrice = rentingPrice;
			this.picture = picture;
		}
		
		public Plane(int planeID) {
			this.planeID=planeID;
			this.planeModel = "";
			this.owner = "";
			this.registration = "";
			this.seatNumber = 0;
			this.flightHours = 0;
			this.rentingPrice = 0;
			this.picture = null;
		}

		public int getPlaneID() {
			return planeID;
		}

		public void setPlaneID(int planeID) {
			this.planeID=planeID;
		}
		
		public String getPlaneModel() {
			return planeModel;
		}

		public void setPlaneModel(String planeModel) {
			this.planeModel = planeModel;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}
		
		public String getRegistration() {
			return registration;
		}

		public void setRegistration(String registration) {
			this.registration = registration;
		}

		public int getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(int seatNumber) {
			this.seatNumber = seatNumber;
		}
		
		public int getFlightHours() {
			return flightHours;
		}

		public void setFlightHours(int flightHours) {
			this.flightHours = flightHours;
		}
		
		public int getRentingPrice() {
			return rentingPrice;
		}

		public void setRentingPrice(int rentingPrice) {
			this.rentingPrice = rentingPrice;
		}
		
		public Image getPicture() {
			return picture;
		}

		public void setPicture(Image picture) {
			this.picture = picture;
		}
		
		
	}

	private int flightID;
	private Plane plane;
	private String typeOfFlight;
	private String departureAirport;
	private String arrivalAirport;
	private LocalTime duration;
	private LocalDate depatureDate;
	private LocalDate arrivalDate;
	
	//thing about the last date before close the booking
	
	private String flightTitle;
	private String flightDescription;
	private List<Passenger> passengerInFlight;
	private int pricePerPassenger;
	
	public Flight(int flightID, Plane plane, String typeOfFlight, String departureAirport, String arrivalAirport, LocalTime duration,
			LocalDate depatureDate, LocalDate arrivalDate, String flightTitle, String flightDescription,
			List<Passenger> passengerInFlight, int pricePerPassenger) {
		this.flightID=flightID;
		this.plane = plane;
		this.typeOfFlight = typeOfFlight;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.duration = duration;
		this.depatureDate = depatureDate;
		this.arrivalDate = arrivalDate;
		this.flightTitle = flightTitle;
		this.flightDescription = flightDescription;
		this.passengerInFlight = passengerInFlight;
		this.pricePerPassenger = pricePerPassenger;
	}
	
	public Flight(int flightID)
	{
		this.flightID=flightID;
		this.plane = null;
		this.typeOfFlight = "";
		this.departureAirport = "";
		this.arrivalAirport = "";
		this.duration = null;
		this.depatureDate = null;
		this.arrivalDate = null;
		this.flightTitle = "";
		this.flightDescription = "";
		this.passengerInFlight = null;
		this.pricePerPassenger = 0;	
	}
	
	public int getFlightID(){
		return this.flightID;
	}

	public void setFlightID(int flightID){
		this.flightID=flightID;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public String getTypeOfFlight() {
		return typeOfFlight;
	}

	public void setTypeOfFlight(String typeOfFlight) {
		this.typeOfFlight = typeOfFlight;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	
	public LocalDate getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(LocalDate depatureDate) {
		this.depatureDate = depatureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getFlightTitle() {
		return FlightTitle;
	}

	public void setFlightTitle(String flightTitle) {
		FlightTitle = flightTitle;
	}

	public String getFlightDescription() {
		return FlightDescription;
	}

	public void setFlightDescription(String flightDescription) {
		FlightDescription = flightDescription;
	}

	public List<Passenger> getPassengerInFlight() {
		return passengerInFlight;
	}

	public void setPassengerInFlight(List<Passenger> passengerInFlight) {
		this.passengerInFlight = passengerInFlight;
	}

	public int getPricePerPassenger() {
		return pricePerPassenger;
	}

	public void setPricePerPassenger(int pricePerPassenger) {
		pricePerPassenger = pricePerPassenger;
	}

}
