package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.Country;
import dev.hermyny.sa.service.CountryService;

@RestController
@RequestMapping(path = "country", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
	
	private CountryService countryService;
	
	
	public CountryController(CountryService countryService) {
		
		this.countryService = countryService;
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Country country) {
		
		this.countryService.create(country);
	}
	
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Country> search() {
		return this.countryService.search();
		
	}
	
	
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Country read(@PathVariable int id) {
		return this.countryService.read(id);
		
	}

}
