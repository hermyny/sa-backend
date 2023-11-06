package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Continent> search() { 
		return this.continentRepository.findAll(); 
		}
	
	
	 public Continent getContinentById(int id) {
			Optional<Continent> optionalContinent = this.continentRepository.findById(id);
			if(optionalContinent.isPresent()) {
				return optionalContinent.orElse(null);
			
			}
			return null;
			
		}
	
	public Continent readOrCreate(Continent continentToAdd) {
		Continent continentInBdd = this.continentRepository.findByName(continentToAdd.getName());
		if(continentInBdd == null ) {
		continentInBdd = this.continentRepository.save(continentToAdd);
	
		}
		
		return continentInBdd;
		
	}
	
	
	public void deleteContinent(int id) {
		Continent continent = continentRepository.findById(id).orElse(null);
		   if (continent != null) {
			   this.continentRepository.delete(continent);
		   } else {
			   throw new RuntimeException("Le continent numéro" + id + " est introuvable");
		   }
		}
	
	
	public void editContinent(Continent continent) {
		Continent continentExisting = continentRepository.findById(continent.getId()).orElse(null);
		if(continentExisting != null ) {
			this.continentRepository.save(continent);
			}
		 }
		
}
