package com.tiarg.persons.trips.services;

import java.util.Set;

import com.tiarg.persons.trips.model.PersonTrip;
import com.tiarg.persons.trips.model.PersonTripFilter;

/**
 * Interface persons trips services.
 *
 * @author mauro-sanchez
 */
public interface PersonsTripsService {
	
	public Set<PersonTrip> filterPersonsTrips(PersonTripFilter personFilter);
	
}
