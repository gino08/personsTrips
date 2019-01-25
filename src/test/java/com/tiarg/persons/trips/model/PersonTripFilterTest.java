package com.tiarg.persons.trips.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link PersonTripFilter} class.
 * 
 * @author mauro-sanchez
 */
public class PersonTripFilterTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullPathFile_when_createPersonTripFilter_then_nullPointerException() {
		PersonTripFilter.of(null, "key", "value");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullKey_when_createPersonTripFilter_then_nullPointerException() {
		PersonTripFilter.of("pathFile", null, "value");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullValue_when_createPersonTripFilter_then_nullPointerException() {
		PersonTripFilter.of("pathFile", "key", null);
	}
	
	@Test
	public void given_allData_when_createPersonTripFilter_then_createSuccess() {
		Assert.assertNotNull(PersonTripFilter.of("pathFile", "key", "value"));
	}
    
}
