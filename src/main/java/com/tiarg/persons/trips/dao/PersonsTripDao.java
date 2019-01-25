package com.tiarg.persons.trips.dao;

import java.util.Set;

import com.tiarg.persons.trips.model.PersonTrip;
import com.tiarg.persons.trips.model.PersonTripFilter;

/**
 * Interface manage PersonTrip.
 *
 * @author mauro-sanchez
 */
public interface PersonsTripDao {
	
	Set<PersonTrip> filterPersonsTrips(PersonTripFilter personTripFilter);
	
	boolean isExistFile(String path);
	
}
