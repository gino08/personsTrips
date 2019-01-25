package com.tiarg.persons.trips.ui;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.tiarg.persons.trips.model.PersonTrip;

/**
 * Implementation of the interface {@link PersonsTripsUI}.
 * use the system console.
 *
 * @author mauro-sanchez
 */
public class PersonsTripsUIConsole implements PersonsTripsUI {
	
	private final Scanner scanner;

    public PersonsTripsUIConsole() {
        scanner = new Scanner(System.in);
    }

	@Override
	public void initPersonsTrips() {
		System.out.println("\nFiltering data...\n");
	}

	@Override
	public void exitPersonsTrips() {
		System.out.println("\n***************************************************");
    	System.out.println(".:                Persons Trips finalize           :.");
    	System.out.println("***************************************************\n");
	}

	@Override
	public void printMessage(String change) {
		System.out.println(change);
	}

	@Override
	public void printResultsByCity(Set<PersonTrip> result) {
		if (result == null)
			return;
		if (result.isEmpty()) {
			printMessage("NO SUCH RESULTS.\n");
		}
		else {
			result.stream().forEach(personTrip -> {
				printMessage(personTrip.getNameAndSurname() + "," + personTrip.getId());
			});
			printMessage("\n");
			
		}
	}

	@Override
	public void printResultsById(Set<PersonTrip> result) {
		if (result == null)
			return;
		if (result.isEmpty()) {
			printMessage("NO SUCH RESULTS.\n");
		}
		else {
			List<String> citysUnrepeated = result.stream().
												map(personTrip -> personTrip.getCity()).
												distinct().
												collect(Collectors.toList());
			
			citysUnrepeated.stream().forEach(cityPersonTrip -> {
				printMessage(cityPersonTrip);
			});
			printMessage("\n");
		}
	}

}
