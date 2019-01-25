package com.tiarg.persons.trips;

import java.util.Set;

import com.tiarg.persons.trips.model.PersonTrip;

/**
 * Interface Persons Trips.
 *
 * @author mauro-sanchez
 */
public interface PersonsTrips {

	Set<PersonTrip> filterPersonsTrips();
	
	void exitPersonsTrips();
	
}
