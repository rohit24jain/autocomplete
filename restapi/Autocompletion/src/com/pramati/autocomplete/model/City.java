package com.pramati.autocomplete.model;

import javax.ws.rs.ext.Provider;

@Provider
/*
 * contains name field.
 * It can have other fields also 
 * like area, pin-code, state if needed in future
 */
public class City {

	String name;
	 public City(){
		 
	 }
	public City(String cityName) {
		this.name = cityName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
