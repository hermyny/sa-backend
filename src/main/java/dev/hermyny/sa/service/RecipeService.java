package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Continent;
import dev.hermyny.sa.model.Country;
import dev.hermyny.sa.model.Recipe;
import dev.hermyny.sa.repository.RecipeRepository;

public class RecipeService {
	
	private CategoryService categoryService;
	private RecipeRepository recipeRepository;
	
	
	public RecipeService(CategoryService categoryService, RecipeRepository recipeRepository) {
		
		this.categoryService = categoryService;
		this.recipeRepository = recipeRepository;
	}
	
	
	public void create(Recipe recipe) {
		Category category = this.categoryService.readOrCreate(recipe.getCategory());
		recipe.setCategory(category);
		this.recipeRepository.save(recipe);
		
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
