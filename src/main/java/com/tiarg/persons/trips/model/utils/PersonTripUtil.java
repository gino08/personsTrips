package com.tiarg.persons.trips.model.utils;

import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tiarg.persons.trips.PersonsTripsConstants;
import com.tiarg.persons.trips.model.PersonTrip;

/**
 * Util methods for {@link PersonTrip}.
 *
 * @author mauro-sanchez
 */
public final class PersonTripUtil {

    public static Comparator<PersonTrip> ROUTES_ORDER_BY_NAME_AND_SURNAME = Comparator.comparing(PersonTrip::getNameAndSurname);
    
    /**
     * Determines if a simple string representation of a Id is valid for format F1.
     *
     * @param id  a simple string representation of a id
     * @return true if the input string has a valid format for format F1, otherwise, false
     */
    public static boolean isValidFormatId_F1(String id) {
    	Objects.requireNonNull(id, "id cannot be null");
    	Pattern pattern = Pattern.compile(PersonsTripsConstants.PATTERN_FORMAT_F1);
    	Matcher matcher = pattern.matcher(id);
    	return matcher.matches();
    }
    
    /**
     * Determines if a simple string representation of a Id is valid for format F2.
     *
     * @param id  a simple string representation of a id
     * @return true if the input string has a valid format for format F2, otherwise, false
     */
    public static boolean isValidFormatId_F2(String id) {
    	Objects.requireNonNull(id, "id cannot be null");
    	Pattern pattern = Pattern.compile(PersonsTripsConstants.PATTERN_FORMAT_F2);
    	Matcher matcher = pattern.matcher(id);
    	return matcher.matches();
    }
    
    /**
     * Given a simple string representation a data of person trip and simple string representation a type of format
     * it return a {@link PersonTrip} object.
     *
     * @param dataPersonTrip  a simple string representation a data of person trip
     * @param format  a simple string representation a type of format
     * @return a {@link PersonTrip}
     */
    public static PersonTrip getPersonTripByFormat(String dataPersonTrip, String format) {
    	String[] data = null;
    	
    	switch (format) {
		case PersonsTripsConstants.F1:
			data = dataPersonTrip.split(PersonsTripsConstants.F1_SEPARATE);
			break;
		case PersonsTripsConstants.F2:
			data = dataPersonTrip.split(PersonsTripsConstants.F2_SEPARATE);
			break;
		default:
			break;
		}
    	
    	if (data != null && data.length == 3)
    		return PersonTrip.of(data[0].substring(2), data[1], data[2]);
    	return null;
    }
}
