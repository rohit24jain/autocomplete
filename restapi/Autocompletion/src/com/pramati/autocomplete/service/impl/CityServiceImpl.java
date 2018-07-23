package com.pramati.autocomplete.service.impl;

import java.util.List;

import com.pramati.autocomplete.model.City;
import com.pramati.autocomplete.model.QueryParams;
import com.pramati.autocomplete.service.CityService;
import com.pramati.autocomplete.util.CityDictionary;

public class CityServiceImpl implements CityService{

	@Override
	public List<String> getCities(QueryParams params) {
		return CityDictionary.getRoot().searchCity(params.getStart().toLowerCase(), params.getAtmost());
	}
	
}
