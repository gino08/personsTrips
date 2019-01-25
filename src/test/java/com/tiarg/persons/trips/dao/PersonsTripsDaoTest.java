package com.tiarg.persons.trips.dao;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.tiarg.persons.trips.PersonsTripsConstants;
import com.tiarg.persons.trips.model.PersonTrip;
import com.tiarg.persons.trips.model.PersonTripFilter;

/**
 * Unit tests for {@link PersonsTripDao} class.
 * 
 * @author mauro-sanchez
 */
public class PersonsTripsDaoTest {
	
	public static final String PERSONS_TRIPS_FILE_VALID_PATH = "./src/test/resources/personsTrips.txt";
	public static final String PERSONS_TRIPS_FILE_INVALID_PATH = "./src/test/resources/test.txt";
	

	@Test
	public void given_aValidPath_when_tryFilterPersonsTrips_then_returnResult() {
		PersonsTripDao personsTripsDao = new PersonsTripsDaoTxtImpl();
		Set<PersonTrip> result = personsTripsDao.filterPersonsTrips(PersonTripFilter.of(PERSONS_TRIPS_FILE_VALID_PATH, PersonsTripsConstants.CITY_KEY, "CITY"));
		Assert.assertNotNull(result);
	}
	
	@Test
	public void given_aInvalidPath_when_tryFilterPersonsTrips_then_returnNull() {
		PersonsTripDao personsTripsDao = new PersonsTripsDaoTxtImpl();
		Set<PersonTrip> result = personsTripsDao.filterPersonsTrips(PersonTripFilter.of(PERSONS_TRIPS_FILE_INVALID_PATH, PersonsTripsConstants.CITY_KEY, "CITY"));
		Assert.assertNull(result);
	}

	@Test
	public void given_aExistFile_when_verifiedIfExist_then_returnTrue() {
		PersonsTripDao personsTripsDao = new PersonsTripsDaoTxtImpl();
		Assert.assertTrue(personsTripsDao.isExistFile(PERSONS_TRIPS_FILE_VALID_PATH));
	}
	
	@Test
	public void given_aNotExistFile_when_verifiedIfExist_then_returnFalse() {
		PersonsTripDao personsTripsDao = new PersonsTripsDaoTxtImpl();
		Assert.assertFalse(personsTripsDao.isExistFile(PERSONS_TRIPS_FILE_INVALID_PATH));
	}
}
