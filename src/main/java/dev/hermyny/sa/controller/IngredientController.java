package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import dev.hermyny.sa.model.Ingredient;
import dev.hermyny.sa.service.IngredientService;


@RestController
@RequestMapping(path = "ingredient", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientController {

	private IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		
		this.ingredientService = ingredientService;
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Ingredient ingredient) {
		
		this.ingredientService.create(ingredient);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ingredient> search() {
		return this.ingredientService.search();
		
	}
	
	
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ingredient read(@PathVariable int id) {
		return this.ingredientService.read(id);
		
	}
	
	
}
