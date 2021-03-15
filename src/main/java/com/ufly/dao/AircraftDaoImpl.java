/**
 * 
 */
package com.ufly.dao;

import com.ufly.Aircraft;

/**
 * @author Paul
 *
 */
public class AircraftDaoImpl implements AircraftDao {

	public Aircraft getAircraftInfo(int aircraftID) {
		// fonction qui renvoie les infos de l'avion correspondant � AircraftID
		// on part du principe qu'elle renvoie un Aircraft, on va en cr�er un par defaut pour faire le test
		return new Aircraft(aircraftID);
	}

}
