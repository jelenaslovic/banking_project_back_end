package com.iktpreobuka.banking_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking_project.model.enumeration.City;
import com.iktpreobuka.banking_project.model.enumeration.Country;

@CrossOrigin(origins = "*")
@RestController
public class EnumController {

	@GetMapping("/cities")
	public List<City> findAllCities() {
		List<City> cities = new ArrayList<>();
		for (City city : City.values()) {
			cities.add(city);
		}
		return cities;
	}

	@GetMapping("/countries")
	public List<Country> findAllCountries() {
		List<Country> countries = new ArrayList<>();
		for (Country country : Country.values()) {
			countries.add(country);
		}
		return countries;
	}

}
