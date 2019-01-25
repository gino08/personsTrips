package com.tiarg.persons.trips.model;

import java.util.Objects;

/**
 * Object representing a data of person trip.
 * 
 * @author mauro-sanchez
 */
public final class PersonTrip {
	
	private String nameAndSurname;
	private String city;
	private String id;
	
	
	private PersonTrip(String nameAndSurname, String city, String id) {
		Objects.requireNonNull(nameAndSurname, "nameAndSurname cannot be null");
		Objects.requireNonNull(city, "city cannot be null");
		Objects.requireNonNull(id, "id cannot be null");
		this.nameAndSurname = nameAndSurname;
		this.city= city;
		this.id = id;
	}
	
	public static PersonTrip of(String nameAndSurname, String city, String id) {
        return new PersonTrip(nameAndSurname, city, id);
    }
	
	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
    public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
	        return true;
		}
	    if (obj.getClass() != getClass())
	        return false;
	    
        PersonTrip personTrip = (PersonTrip) obj;
        return nameAndSurname.equals(personTrip.getNameAndSurname())
        		&& city.equals(personTrip.getCity())
        		&& id.equals(personTrip.getId());
    }

    @Override
    public int hashCode() {
        return nameAndSurname.hashCode() + city.hashCode() + id.hashCode();
    }
}
