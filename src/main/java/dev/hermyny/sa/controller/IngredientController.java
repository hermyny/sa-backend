package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Ingredient;
import dev.hermyny.sa.service.IngredientService;


@RestController
@RequestMapping(path = "ingredient", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class IngredientController {

	private IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		
		this.ingredientService = ingredientService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", methods = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Ingredient ingredient) {
		
		this.ingredientService.create(ingredient);
	}
	
	
	@GetMapping( path = "read", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", methods = RequestMethod.GET)
	public List<Ingredient> search() {
		return this.ingredientService.search();
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", methods = RequestMethod.GET)
	@GetMapping(path = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ingredient readOrCreateById(@PathVariable int id) {
		return this.ingredientService.readOrCreateById(id);
		
	}
	
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteIngredient(@PathVariable int id) {
		
		this.ingredientService.deleteIngredient(id);
	}
	
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void ingredientCategory(@PathVariable int id, @RequestBody Ingredient ingredient) {
    	
    	this.ingredientService.updateIngredient(id, ingredient);
    }
	
}
