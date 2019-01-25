package com.tiarg.persons.trips.model.utils;

import com.tiarg.persons.trips.PersonsTripsConstants;
import com.tiarg.persons.trips.model.PersonTripFilter;

/**
 * Util methods for {@link PersonTripFilter}.
 *
 * @author mauro-sanchez
 */
public final class PersonTripFilterUtil {
	
	/**
     * Determines if a array of string representation of a data filter is valid.
     *
     * @param data  a array of string representation of a data filter
     * @return true if the input string has a valid, otherwise, false
     */
	public static boolean isValidDataPersonTripFilter(String[] data) {
		if (data == null || (data != null && data.length != 3))
			return Boolean.FALSE;
		
		if (!data[1].toUpperCase().equals(PersonsTripsConstants.CITY_KEY) && !data[1].toUpperCase().equals(PersonsTripsConstants.ID_KEY)) {
			return Boolean.FALSE;
		}
		
		if (data[1].toUpperCase().equals(PersonsTripsConstants.ID_KEY) && !PersonTripUtil.isValidFormatId_F1(data[2]) && !PersonTripUtil.isValidFormatId_F2(data[2])) {
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
    
}
