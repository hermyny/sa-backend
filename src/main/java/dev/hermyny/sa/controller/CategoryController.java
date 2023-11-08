package dev.hermyny.sa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.service.CategoryService;

@RestController
@RequestMapping(path = "category")
public class CategoryController {
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	}
	
	
    @ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Category category) {
		
    	this.categoryService.create(category);
	}
    
    
   
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> search() {
		return this.categoryService.search();
		
	}
    
    
    @GetMapping(path = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Category readOrCreateById(@PathVariable int id) {
		return this.categoryService.readOrCreateById(id);
		
	}
    

    
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCategory(@PathVariable int id) {
		
		this.categoryService.deleteCategory(id);
	}
    
    
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
    	
    	this.categoryService.updateCategory(id, category);
    }
    
    

}
