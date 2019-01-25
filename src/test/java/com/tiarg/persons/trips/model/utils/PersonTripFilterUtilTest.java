package com.tiarg.persons.trips.model.utils;

import org.junit.Assert;
import org.junit.Test;

import com.tiarg.persons.trips.model.utils.PersonTripFilterUtil;

/**
 * Unit tests for {@link PersonFilterUtil} class.
 * 
 * @author mauro-sanchez
 */
public class PersonTripFilterUtilTest {
	
	@Test
	public void given_aValidDataFilter_when_validDataFilterTrip_then_true() {
		Assert.assertTrue(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "CITY", "BARCELONA"}));
		Assert.assertTrue(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "ID", "12345678Z"}));
		Assert.assertTrue(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "ID", "12345678-Z"}));
	}
	
	@Test
	public void given_aInvalidDataFilter_when_validDataFilterTrip_then_false() {
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"CITY", "BARCELONA"}));
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "KEY", "BARCELONA"}));
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "ID", "1234567Z"}));
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "ID", "12345678--Z"}));
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "ID", "12345678-"}));
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {"path.txt", "ID", "12345678-ZZ"}));
		Assert.assertFalse(PersonTripFilterUtil.isValidDataPersonTripFilter(new String[] {}));
	}
}
