package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


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
	
	public Ingredient read(int id) {
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
	
	
//	public List<Ingredient> createListByRecipe(List<Ingredient> ingredientsToAdd) {
//	    List<Ingredient> resultIngredients = new ArrayList<>();
//
//	    for (Ingredient ingredientToAdd : ingredientsToAdd) {
//	        Ingredient ingredientInBdd = this.ingredientRepository.findByName(ingredientToAdd.getName());
//
//	        if (ingredientInBdd == null) {
//	            resultIngredients.add(ingredientToAdd);
//	        } else {
//	            resultIngredients.add(ingredientInBdd);
//	        }
//	    }
//	    	
//	    return resultIngredients;
//	}
//	




//	public List<Ingredient> createListByRecipe(){
//		
//		List<Ingredient> ingredients = new ArrayList<>();
//		Ingredient createdIngredient = this.ingredientService.readOrCreate();
//		 for (Ingredient ingredient : recipe.getIngredients()) {
//		        
//			 	ingredients.add(createdIngredient);
//		        
//		        System.out.println(createdIngredient);
//		    }
//	}
}
