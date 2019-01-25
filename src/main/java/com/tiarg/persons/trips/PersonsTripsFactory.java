package com.tiarg.persons.trips;

import com.tiarg.persons.trips.model.PersonTripFilter;
import com.tiarg.persons.trips.model.utils.PersonTripFilterUtil;
import com.tiarg.persons.trips.ui.PersonsTripsUIConsole;

/**
 * Convenient factory of different
 * implementations of the {@link PersonsTrips}.
 *
 * @author mauro-sanchez
 */
public final class PersonsTripsFactory {

    public static PersonsTrips newPersonsTripsImpl(String[] arguments) {
    	if (PersonTripFilterUtil.isValidDataPersonTripFilter(arguments)) {
    		PersonTripFilter personTripFilter = PersonTripFilter.of(arguments[0], arguments[1], arguments[2]);
    		return PersonsTripsImpl.createPersonsTrips(personTripFilter, new PersonsTripsUIConsole());
    	}
        return null;
    }

}
