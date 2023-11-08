package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Continent;
import dev.hermyny.sa.model.Country;

import dev.hermyny.sa.repository.CountryRepository;

@Service
public class CountryService {
	
	private ContinentService continentService;
	private CountryRepository countryRepository;
	
	
	
	
	public CountryService(ContinentService continentService, CountryRepository countryRepository) {
		
		this.continentService = continentService;
		this.countryRepository = countryRepository;
	}




	public void create(Country country) {
		Continent continent = this.continentService.readOrCreate(country.getContinent());
		country.setContinent(continent);
		this.countryRepository.save(country);
		
	}	
	
	
	public List<Country> search(){
		return this.countryRepository.findAll();
	}
	
	
	public Country readOrCreateById(int id) {
		Optional<Country> optionalCountry = this.countryRepository.findById(id);
		if(optionalCountry.isPresent()) {
			return optionalCountry.orElse(null);
		
		}
		return null;
		
	}
	
	
	
	public Country readOrCreate(Country countryToAdd) {
		Country countryInBdd = this.countryRepository.findByName(countryToAdd.getName());
		if(countryInBdd == null ) {
		countryInBdd = this.countryRepository.save(countryToAdd);
	
		}
		
		return countryInBdd;
		
	}
	
	public void deleteCountry(int id) {
		Country country = countryRepository.findById(id).orElse(null);
		   if (country != null) {
			   this.countryRepository.deleteById(id);
		   } else {
			   throw new RuntimeException("Le pays numéro" + id + " est introuvable");
		   }
		}
	
	
	public void updateCountry(int id, Country country) {
		Country countryInBdd = this.readOrCreateById(id);
		Continent continent = this.continentService.readOrCreate(countryInBdd.getContinent());

		if (countryInBdd.getId() != country.getId()) {
			countryInBdd.setName(country.getName());
			countryInBdd.setContinent(continent);
			
			this.countryRepository.save(countryInBdd);
		}
			
	}
	
}


