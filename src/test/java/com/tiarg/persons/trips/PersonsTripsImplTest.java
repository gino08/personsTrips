package com.tiarg.persons.trips;

import org.junit.Assert;
import org.junit.Test;

import com.tiarg.persons.trips.PersonsTrips;
import com.tiarg.persons.trips.PersonsTripsFactory;
import com.tiarg.persons.trips.PersonsTripsImpl;

/**
 * Unit tests for {@link PersonsTripsImpl} class.
 *
 * @author mauro-sanchez
 */
public class PersonsTripsImplTest {
	
	public static final String PERSONS_TRIPS_FILE_VALID_PATH = "./src/test/resources/personsTrips.txt";
	public static final String PERSONS_TRIPS_FILE_INVALID_PATH = "./src/test/resources/test.txt";
	
	@Test 
	public void given_aValidDataFilter_when_filterPersonsTrips_then_returnEquals() {
		PersonsTrips personsTrips = PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "CITY", "BARCELONA"});
		Assert.assertEquals(new Integer(10), new Integer(personsTrips.filterPersonsTrips().size()));
		
		personsTrips = PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "CITY", "LAS VEGAS"});
		Assert.assertEquals(new Integer(13), new Integer(personsTrips.filterPersonsTrips().size()));
		
		personsTrips = PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "CITY", "MADRID"});
		Assert.assertEquals(new Integer(1), new Integer(personsTrips.filterPersonsTrips().size()));
		
		personsTrips = PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "ID", "10863096-N"});
		Assert.assertEquals(new Integer(2), new Integer(personsTrips.filterPersonsTrips().size()));
		
		personsTrips = PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "ID", "69429384C"});
		Assert.assertEquals(new Integer(1), new Integer(personsTrips.filterPersonsTrips().size()));
		
		personsTrips = PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "ID", "12345678Z"});
		Assert.assertEquals(new Integer(0), new Integer(personsTrips.filterPersonsTrips().size()));
	}
	
	@Test 
	public void given_aInvalidDataFilter_when_filterPersonsTrips_then_returnNull() {
		Assert.assertNull(PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "KEY", "BARCELONA"}));
		Assert.assertNull(PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "ID", "12345678"}));
		Assert.assertNull(PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_VALID_PATH, "ID", "1234567Z"}));
		Assert.assertNull(PersonsTripsFactory.newPersonsTripsImpl(new String[] {PERSONS_TRIPS_FILE_INVALID_PATH, "ID", "12345678Z"}).filterPersonsTrips());
	}
	
	
}
