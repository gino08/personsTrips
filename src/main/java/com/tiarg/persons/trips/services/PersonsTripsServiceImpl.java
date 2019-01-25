package com.tiarg.persons.trips.services;

import java.util.Set;

import com.tiarg.persons.trips.dao.PersonsTripDao;
import com.tiarg.persons.trips.dao.PersonsTripsDaoTxtImpl;
import com.tiarg.persons.trips.model.PersonTrip;
import com.tiarg.persons.trips.model.PersonTripFilter;

/**
 * Implementation of the interface {@link PersonsTripsService}.
 * Use {@link PersonsTripDao} for filter persons trips.
 *
 * @author mauro-sanchez
 */
public class PersonsTripsServiceImpl implements PersonsTripsService {
	
	private PersonsTripDao dao;
	
	public PersonsTripsServiceImpl() {
		dao = new PersonsTripsDaoTxtImpl();
	}

	@Override
	public Set<PersonTrip> filterPersonsTrips(PersonTripFilter personTripFilter) {
		return dao.filterPersonsTrips(personTripFilter);
	}
}
