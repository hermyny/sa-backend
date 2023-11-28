package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Country;
import dev.hermyny.sa.model.Ingredient;
import dev.hermyny.sa.repository.IngredientRepository;

@Service
public class IngredientService {

	
	private IngredientRepository ingredientRepository;
	
	
	public IngredientService(IngredientRepository ingredientRepository) {
	
		this.ingredientRepository = ingredientRepository;
	}
	
	
	public void create(Ingredient ingredient) {
		Ingredient IngredientInBdd = this.ingredientRepository.findByName(ingredient.getName());
		if(IngredientInBdd == null) {
		this.ingredientRepository.save(ingredient);
		}
	}
	
	
	public List<Ingredient> search(){
		return this.ingredientRepository.findAll();
	}
	
	public Ingredient readOrCreateById(int id) {
		Optional<Ingredient> optionalIngredient = this.ingredientRepository.findById(id);
		if(optionalIngredient.isPresent()) {
			return optionalIngredient.orElse(null);
		
		}
		return null;
	}
	
	public Ingredient readOrCreate(Ingredient ingredientToAdd) {
		Ingredient ingredientInBdd = this.ingredientRepository.findByName(ingredientToAdd.getName());
		if(ingredientInBdd == null ) {
		ingredientInBdd = this.ingredientRepository.save(ingredientToAdd);
	
		}
		
		return ingredientInBdd;
		
	}


	
	public void deleteIngredient(int id) {
		Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
		   if (ingredient != null) {
			   this.ingredientRepository.deleteById(id);
		   } else {
			   throw new RuntimeException("Le pays numéro" + id + " est introuvable");
		   }
	}
	
	
	
	
	public void updateIngredient(int id, Ingredient ingredient) {
		Ingredient ingredientInBdd = this.readOrCreateById(id);
		if (ingredientInBdd.getId() != ingredient.getId()) {
			ingredientInBdd.setName(ingredient.getName());
			ingredientInBdd.setCalorie(ingredient.getCalorie());
			ingredientInBdd.setType(ingredient.getType());


			this.ingredientRepository.save(ingredientInBdd);
		}
			
	}
}
