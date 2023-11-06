package dev.hermyny.sa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Country;
import dev.hermyny.sa.model.Ingredient;
import dev.hermyny.sa.model.Recipe;
import dev.hermyny.sa.repository.RecipeRepository;


@Service
public class RecipeService {
	
	
    
	private CategoryService categoryService;
	private CountryService countryService;
	private IngredientService ingredientService;
	private RecipeRepository recipeRepository;
	
	
	public RecipeService(CategoryService categoryService, CountryService countryService, IngredientService ingredientService, RecipeRepository recipeRepository) {
		
		this.categoryService = categoryService;
		this.ingredientService = ingredientService;
		this.recipeRepository = recipeRepository;
		this.countryService = countryService;
	}
	
	
	public void create(Recipe recipe) {
		
		Category category = this.categoryService.readOrCreate(recipe.getCategory());
		Country country = this.countryService.readOrCreate(recipe.getCountry());
		
		
		recipe.setCategory(category);
		recipe.setCountry(country);
//		recipe.setIngredients(ingredient);
		
	  this.recipeRepository.save(recipe);

		System.out.println(recipe);
		
	}	
	
	public List<Recipe> search(){
		return this.recipeRepository.findAll();
	}
	
	public Recipe read(int id) {
		Optional<Recipe> optionalRecipe = this.recipeRepository.findById(id);
		if(optionalRecipe.isPresent()) {
			return optionalRecipe.orElse(null);
		
		}
		return null;
	}
	
	
}
