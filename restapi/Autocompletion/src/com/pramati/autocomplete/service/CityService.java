package com.pramati.autocomplete.service;

import com.pramati.autocomplete.model.*;
import java.util.List;
public interface CityService {

	public List<String> getCities(QueryParams params);
}
