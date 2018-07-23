package com.pramati.autocomplete.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.pramati.autocomplete.model.QueryParams;
import com.pramati.autocomplete.service.CityService;
import com.pramati.autocomplete.service.impl.CityServiceImpl;
import com.pramati.autocomplete.util.CityDictionary;

public class FileReadContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent scEvent)  {

		System.out.println("city web services..conext listener destroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent scEvent) {

		System.out.println("city web services..conext listener initialized");
		String fileName = (String)scEvent.getServletContext().getInitParameter("cityFile");
		System.out.println("file name .."+fileName);
		InputStream inputStream = scEvent.getServletContext().getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String cityName = null;
		try {
			while ((cityName = reader.readLine())!= null){
				CityDictionary.getRoot().insertCity(cityName);
			}
			/*CityService cityService = new CityServiceImpl();
			QueryParams params = new QueryParams();
			params.setAtmost(3);
			params.setStart("Tat");
			List<String> citiesList = cityService.getCities(params);*/
			System.out.println("cities loaded...");
		} catch (IOException e) {
			System.err.println("city file could not be read!..."+e.getMessage()+" cause :"+e.getCause());
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println("file resource closing exception!");
			}
		}
		
	
	}

}
