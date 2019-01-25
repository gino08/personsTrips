package com.tiarg.persons.trips.model.utils;

import org.junit.Assert;
import org.junit.Test;

import com.tiarg.persons.trips.PersonsTripsConstants;
import com.tiarg.persons.trips.model.utils.PersonTripUtil;

/**
 * Unit tests for {@link PersonTripUtil} class.
 * 
 * @author mauro-sanchez
 */
public class PersonTripUtilTest {
	
	@Test
	public void given_aValidIdF1_when_validFormatF1_then_true() {
		Assert.assertTrue(PersonTripUtil.isValidFormatId_F1("12345678H"));
		Assert.assertTrue(PersonTripUtil.isValidFormatId_F1("12345678Z"));
		Assert.assertTrue(PersonTripUtil.isValidFormatId_F1("00000000Z"));
	}
	
	@Test
	public void given_aInvalidIdF1_when_validFormatF1_then_false() {
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F1("1234567H"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F1("12345678"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F1("12345678ZZ"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F1("12345678-H"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F1(""));
	}
	
	@Test
	public void given_aValidIdF2_when_validFormatF2_then_true() {
		Assert.assertTrue(PersonTripUtil.isValidFormatId_F2("12345678-H"));
		Assert.assertTrue(PersonTripUtil.isValidFormatId_F2("12345678-Z"));
		Assert.assertTrue(PersonTripUtil.isValidFormatId_F2("00000000-Z"));
	}
	
	@Test
	public void given_aInvalidIdF2_when_validFormatF2_then_false() {
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F2("1234567-H"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F2("12345678"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F2("12345678-"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F2("12345678-ZZ"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F2("12345678H"));
		Assert.assertFalse(PersonTripUtil.isValidFormatId_F2(""));
	}
	
	@Test
	public void given_aValidDataPersonTripF1_when_getPersonTripByFormatF1_then_returnPersonTrip() {
		Assert.assertNotNull(PersonTripUtil.getPersonTripByFormat("Erica Burns,BARCELONA,93654902Y", PersonsTripsConstants.F1));
	}
	
	@Test
	public void given_aValidDataPersonTripF2_when_getPersonTripByFormatF1_then_returnNull() {
		Assert.assertNull(PersonTripUtil.getPersonTripByFormat("Erica Burns ; BARCELONA ; 93654902Y", PersonsTripsConstants.F1));
	}
	
	@Test
	public void given_aValidDataPersonTripF2_when_getPersonTripByFormatF2_then_returnPersonTrip() {
		Assert.assertNotNull(PersonTripUtil.getPersonTripByFormat("Erica Burns ; BARCELONA ; 93654902Y", PersonsTripsConstants.F2));
	}
	
	@Test
	public void given_aValidDataPersonTripF1_when_getPersonByFormatF2_then_returnNull() {
		Assert.assertNull(PersonTripUtil.getPersonTripByFormat("Erica Burns,BARCELONA,93654902Y", PersonsTripsConstants.F2));
	}
}
