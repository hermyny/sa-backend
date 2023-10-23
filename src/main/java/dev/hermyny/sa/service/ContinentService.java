package dev.hermyny.sa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import dev.hermyny.sa.model.Continent;
import dev.hermyny.sa.repository.ContinentRepository;

@Service
public class ContinentService {
	

	private ContinentRepository continentRepository;
	
	
	public ContinentService(ContinentRepository continentRepository) {
		this.continentRepository = continentRepository;
	}



	public void create(Continent continent) {
		Continent continentInBdd = this.continentRepository.findByName(continent.getName());
		if(continentInBdd == null ) {
		this.continentRepository.save(continent);
		
		}
	 }
	
	public List<Continent> search() { return this.continentRepository.findAll(); }
	
	
	public Continent readOrCreate(Continent continentToAdd) {
		Continent continentInBdd = this.continentRepository.findByName(continentToAdd.getName());
		if(continentInBdd == null ) {
		continentInBdd = this.continentRepository.save(continentToAdd);
	
		}
		
		return continentInBdd;
		
	}
		
}
