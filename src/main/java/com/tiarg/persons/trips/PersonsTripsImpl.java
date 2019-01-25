package com.tiarg.persons.trips;

import java.util.Set;

import com.tiarg.persons.trips.model.PersonTrip;
import com.tiarg.persons.trips.model.PersonTripFilter;
import com.tiarg.persons.trips.services.PersonsTripsService;
import com.tiarg.persons.trips.services.PersonsTripsServiceImpl;
import com.tiarg.persons.trips.ui.PersonsTripsUI;

/**
 * Implementation of the interface {@link PersonsTrips}.
 * 
 * Maintains the state of the Search.
 *
 * @author mauro-sanchez
 */
public class PersonsTripsImpl implements PersonsTrips {

	private PersonTripFilter personTripFilter;
	private PersonsTripsService personsTripsService;
    private PersonsTripsUI personsTripsUI;
    
    private PersonsTripsImpl(PersonTripFilter personTripFilter, PersonsTripsUI personsTripsUI) {
    	this.personTripFilter = personTripFilter;
    	this.personsTripsService = new PersonsTripsServiceImpl();
    	this.personsTripsUI = personsTripsUI;
    }
    
    public static PersonsTrips createPersonsTrips(PersonTripFilter personTripFilter, PersonsTripsUI personsTripsUI) {
        return new PersonsTripsImpl(personTripFilter, personsTripsUI);
    }
    
    @Override
    public Set<PersonTrip> filterPersonsTrips() {
    	this.personsTripsUI.initPersonsTrips();
    	Set<PersonTrip> result = personsTripsService.filterPersonsTrips(personTripFilter);
    	if ("CITY".equals(personTripFilter.getKey().toUpperCase()))
    		this.personsTripsUI.printResultsByCity(result);
    	if ("ID".equals(personTripFilter.getKey().toUpperCase()))
    		this.personsTripsUI.printResultsById(result);
    	return result;
    }
	
	@Override
	public void exitPersonsTrips() {
		this.personsTripsUI.exitPersonsTrips();
	}
}
