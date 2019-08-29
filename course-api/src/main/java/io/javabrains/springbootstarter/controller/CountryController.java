package io.javabrains.springbootstarter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.bean.Country;
import io.javabrains.springbootstarter.exception.CountryNotFoundException;
import io.javabrains.springbootstarter.helper.ResponseData;

@RestController
public class CountryController {

	private List<Country> listOfCountries = new ArrayList();
	  
	public CountryController(){
	
		  Country indiaCountry=new Country(1, "India");
		  Country chinaCountry=new Country(4, "China");
		  Country nepalCountry=new Country(3, "Nepal");
		  Country bhutanCountry=new Country(2, "Bhutan");
		 
		  listOfCountries.add(indiaCountry);
		  listOfCountries.add(chinaCountry);
		  listOfCountries.add(nepalCountry);
		  listOfCountries.add(bhutanCountry);
		
	}
	  
	
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public List<Country> getAllCountries(){
		return listOfCountries;
	}
	
	@RequestMapping(value="/country/{id}",method=RequestMethod.GET)
	public @ResponseBody  ResponseEntity<?>  getCountryInfo(@PathVariable int id){
		try{
		for(Country c: listOfCountries){
			if(c.getId() == id){
				return new ResponseEntity<Country>(c,HttpStatus.OK);
			}
		}
		throw new CountryNotFoundException("No country matching your search.");
		}catch(CountryNotFoundException e){
			System.out.println("error:-"+e.getMessage());
			return new ResponseEntity<ResponseData<String>>(new ResponseData("failed","country not found."),HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/country/{id}",method=RequestMethod.PUT)
	public @ResponseBody  ResponseEntity<?> setCountryInfo(@PathVariable int id, @RequestBody Country country){
		for(Country c: listOfCountries){
			if(c.getId() == id){
				c.setId(country.getId());
				c.setCountryName(country.getCountryName());
				return new ResponseEntity<ResponseData<String>>(new ResponseData("success","country updated successfully"),HttpStatus.OK);
			}
		}
		return new ResponseEntity<ResponseData<String>>(new ResponseData("failed","country not found."),HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/country",method=RequestMethod.POST)
	public @ResponseBody  ResponseEntity<?>  addCountryInfo(@RequestBody Country country){
		listOfCountries.add(country);
		return new ResponseEntity<ResponseData<String>>(new ResponseData("success","country added successfully"),HttpStatus.OK); 
	}
}
