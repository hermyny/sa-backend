package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.Recipe;
import dev.hermyny.sa.service.RecipeService;


@RestController
@RequestMapping(path ="recipe", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeController {
	
	
	private RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		
		
		this.recipeService = recipeService;
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Recipe recipe) {
		this.recipeService.create(recipe);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Recipe> search() {
		return this.recipeService.search();
		
	}
	
	
	@GetMapping(path = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Recipe readOrCreateById(@PathVariable int id) {
		return this.recipeService.readOrCreateById(id);
		
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteRecipe(@PathVariable int id) {
		
		this.recipeService.deleteRecipe(id);
	}
}
