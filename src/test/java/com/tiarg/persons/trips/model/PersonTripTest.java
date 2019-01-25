package com.tiarg.persons.trips.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link PersonTrip} class.
 * 
 * @author mauro-sanchez
 */
public class PersonTripTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullNameAndSurname_when_createPersonTrip_then_nullPointerException() {
		PersonTrip.of(null, "city", "id");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullCity_when_createPersonTrip_then_nullPointerException() {
		PersonTrip.of("nameAndSurname", null, "id");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullId_when_createPersonTrip_then_nullPointerException() {
		PersonTrip.of("nameAndSurname", "city", null);
	}
	
	@Test
	public void given_allData_when_createPersonTrip_then_createSuccess() {
		Assert.assertNotNull(PersonTrip.of("nameAndSurname", "city", "id"));
	}
	
	@Test
	public void given_aTwoPersonTripWithSameData_when_useEquals_then_returnTrue() {
		PersonTrip personTripOne = PersonTrip.of("nameAndSurname1", "city1", "id1");
		PersonTrip personTripTwo = PersonTrip.of("nameAndSurname1", "city1", "id1");
        Assert.assertTrue(personTripOne.equals(personTripTwo));
    }

    @Test
    public void given_aTwoPersonTripWithDifferentData_when_useEquals_then_returnFalse() {
    	PersonTrip personTripOne = PersonTrip.of("nameAndSurname1", "city1", "id1");
		PersonTrip personTripTwo = PersonTrip.of("nameAndSurname2", "city2", "id2");
        Assert.assertFalse(personTripOne.equals(personTripTwo));
    }
    
}
