package com.tiarg.persons.trips.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.tiarg.persons.trips.PersonsTripsConstants;
import com.tiarg.persons.trips.model.PersonTrip;
import com.tiarg.persons.trips.model.PersonTripFilter;
import com.tiarg.persons.trips.model.utils.PersonTripUtil;

/**
 * Implementation of the interface {@link PersonsTripDao}.
 * Manage data in TXT files.
 *
 * @author mauro-sanchez
 */
public class PersonsTripsDaoTxtImpl implements PersonsTripDao {
	
	private final StringBuilder format = new StringBuilder();
	
	@Override
	public Set<PersonTrip> filterPersonsTrips(PersonTripFilter personTripFilter) {
		Set<PersonTrip> result = new HashSet<PersonTrip>();
		
		try (Stream<String> lines = Files.lines(Paths.get(personTripFilter.getPathFile()))) {
			lines.forEach(line -> {
				if (PersonsTripsConstants.FORMAT_INIT == line.charAt(0)) {
					refreshFormat(line);
				}
				if (PersonsTripsConstants.DATA_INIT == line.charAt(0)) {
					PersonTrip personTrip = PersonTripUtil.getPersonTripByFormat(line, format.toString());
					if (PersonsTripsConstants.CITY_KEY.equals(personTripFilter.getKey()) && personTrip.getCity().toUpperCase().equals(personTripFilter.getValue().toUpperCase())) {
						result.add(personTrip);
					}
					if (PersonsTripsConstants.ID_KEY.equals(personTripFilter.getKey()) && personTrip.getId().equals(personTripFilter.getValue())) {
						result.add(personTrip);
					}
				}
			});
			lines.close();
		} catch (IOException e) {
			System.out.println("File not found.\n");
			return null;
		}
		return result;
	}
	
	public void refreshFormat(String format) {
		this.format.setLength(0);
		this.format.append(format);
	}
	
	@Override
	public boolean isExistFile(String path) {
		File file = new File(path);
		return file.exists();
	}
	
}
