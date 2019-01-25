package com.tiarg.persons.trips.model;

import java.util.Objects;

/**
 * Object representing a to filter persons trips. 
 * 
 * @author mauro-sanchez
 */
public final class PersonTripFilter {
	
	private String pathFile;
	private String key;
	private String value;
	
	
	private PersonTripFilter(String pathFile, String key, String value) {
		Objects.requireNonNull(pathFile, "pathFile cannot be null");
		Objects.requireNonNull(key, "key cannot be null");
		Objects.requireNonNull(value, "id cannot be null");
		this.pathFile = pathFile;
		this.key= key;
		this.value = value;
	}
	
	public static PersonTripFilter of(String pathFile, String key, String value) {
        return new PersonTripFilter(pathFile, key, value);
    }

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
