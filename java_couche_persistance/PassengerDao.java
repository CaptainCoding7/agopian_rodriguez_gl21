public interface PassengerDao {


	/**
	 * Add a new user
	 * @PUT
	 */
	void CreateANewUser();

	/**
	 * Get user information
	 * @GET
	 */
	Passenger GetInfosFromUser(int idUser);

	/**
	 * Edit user information
	 * @POST
	 */
	void EditUserInfos(int idUser);

	/**
	 * Book a number of seats for a flight designated by his id 
	 * @POST
	 */
	void bookAFlight(int idFlight, int nbBookedSeats);


	/**
	 * Give a note for a pilot (designated by his id)
	 * @POST
	 */
	void noteAPilot(int idUser);


	/**
	 * Get the list of flights for which the passenger is concerned
	 * @GET
	 */
	List<Flights> getFlightsList(int idUser);

}
