package dev.hermyny.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.Continent;
import dev.hermyny.sa.service.ContinentService;

@RestController
@RequestMapping(path = "continent")
public class ContinentController {
	
	 private ContinentService continentService;
	 
	 public ContinentController(ContinentService continentService) {
		this.continentService = continentService;
	}

	 @ResponseStatus(value = HttpStatus.CREATED)
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	 public void create(@RequestBody Continent continent) {
		
			this.continentService.create(continent);
		 
	 }
	 
	 
	
}

