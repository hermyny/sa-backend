package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Country;
import dev.hermyny.sa.service.CountryService;

@CrossOrigin
@RestController
@RequestMapping(path = "country", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
	
	private CountryService countryService;
	
	
	public CountryController(CountryService countryService) {
		
		this.countryService = countryService;
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Country country) {
		
		this.countryService.create(country);
	}
	
	
	
	@GetMapping(path = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Country> search() {
		return this.countryService.search();
		
	}
	
	
	@GetMapping(path = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Country readOrCreateById(@PathVariable int id) {
		return this.countryService.readOrCreateById(id);
		
	}
	
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCountry(@PathVariable int id) {
		this.countryService.deleteCountry(id);
	}
	

//  @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCountry(@PathVariable int id, @RequestBody Country country) {
    	
    	this.countryService.updateCountry(id, country);
    }

}
