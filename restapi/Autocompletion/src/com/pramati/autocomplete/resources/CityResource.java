package com.pramati.autocomplete.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.pramati.autocomplete.model.City;
import com.pramati.autocomplete.model.QueryParams;
import com.pramati.autocomplete.service.CityService;
import com.pramati.autocomplete.service.impl.CityServiceImpl;


import java.util.ArrayList;
import java.util.List;

import jersey.repackaged.com.google.common.base.Joiner;

//@Provider
@Path("/")
public class CityResource {

	CityService cityService = new CityServiceImpl();
	
	@GET
	@Path("/suggest_cities")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCitiesList(@BeanParam QueryParams params){
		
		if(params == null || params.getAtmost()<1 || params.getStart()==null){
			throw new WebApplicationException(
					Response.status(Status.BAD_REQUEST).entity("Wrong/Insufficient Parameters").type(MediaType.TEXT_PLAIN).build()
					);
		}
		List<String> citiesList = cityService.getCities(params);	
		
		String citiesTxt = Joiner.on("\n").join(citiesList);
		Response response = Response.status(Status.OK).entity(citiesTxt).type(MediaType.TEXT_PLAIN).build();
		System.out.println(citiesTxt);
		return response;
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCitiesListText(@BeanParam QueryParams params){
		System.out.println("request received ..");
		return "hello..";
	}
}
