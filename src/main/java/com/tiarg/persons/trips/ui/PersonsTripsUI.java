package com.tiarg.persons.trips.ui;

import java.util.Set;

import com.tiarg.persons.trips.model.PersonTrip;

/**
 * Interface for interaction with the user.
 *
 * @author mauro-sanchez
 */
public interface PersonsTripsUI {

	void initPersonsTrips();
	
	void exitPersonsTrips();
	
	void printMessage(String change);
	
	void printResultsByCity(Set<PersonTrip> result);
	
	void printResultsById(Set<PersonTrip> result);
}
