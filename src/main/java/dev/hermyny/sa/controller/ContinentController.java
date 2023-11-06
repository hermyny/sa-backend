package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Continent> search() {
		 return this.continentService.search();
	 }
	 
	 
	 @GetMapping(path = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Continent read(@PathVariable int id) {
			return this.continentService.getContinentById(id);
			
		}
	 
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteContinent(@PathVariable int id) {
		this.continentService.deleteContinent(id);
	}
	

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping(path = "edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editContinent(@RequestBody Continent continent) {
    	
    	this.continentService.editContinent(continent);
    }
}

