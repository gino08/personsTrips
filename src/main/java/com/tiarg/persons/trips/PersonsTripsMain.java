package com.tiarg.persons.trips;

/**
 * Application's entry point.
 *
 * @author mauro-sanchez
 */
public final class PersonsTripsMain {
	
	public static void main(String[] args) {
		
		System.out.println("\n*****************************************");
        System.out.println("******     .:  Persons Trips  :.    *******");
        System.out.println("*****************************************");
        
        PersonsTrips personsTrips = PersonsTripsFactory.newPersonsTripsImpl(args);
        if (personsTrips != null) 
        	personsTrips.filterPersonsTrips();
        else
        	System.out.println("\nIncorrect parameters.\n");
    }
}
