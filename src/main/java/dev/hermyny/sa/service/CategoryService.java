package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.repository.CategoryRepository;



@Service
public class CategoryService {
	
	
	private CategoryRepository categoryRepository;
	
	
	public CategoryService(CategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}
	
	
	
	public void create(Category category) {
		
		Category categoryInBdd = this.categoryRepository.findByTitle(category.getTitle());
		if(categoryInBdd == null ) {
		this.categoryRepository.save(category);
		}
	 }
	
	
	
    public List<Category> search() { 
    	return this.categoryRepository.findAll(); 
    	}
	
    
    public Category readOrCreateById(int id) {
		Optional<Category> optionalCategory = this.categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.orElse(null);
		
		}
		return null;
		
	}
	
	public Category readOrCreate(Category categoryToAdd) {
		Category categoryInBdd = this.categoryRepository.findByTitle(categoryToAdd.getTitle());
		if(categoryInBdd == null ) {
		categoryInBdd = this.categoryRepository.save(categoryToAdd);
	
		}
		
		return categoryInBdd;
		
	}
	
	public void deleteCategory(int id) {
	   Category category = categoryRepository.findById(id).orElse(null);
	   if (category != null) {
		   this.categoryRepository.deleteById(id);
	   } else {
		   throw new RuntimeException("La categorie numéro" + id + " est introuvable");
	   }
	}
	
	

	public void updateCategory(int id, Category category) {
		Category categoryInBdd = this.readOrCreateById(id);
		if (categoryInBdd.getId() != category.getId()) {
			categoryInBdd.setTitle(category.getTitle());
			this.categoryRepository.save(categoryInBdd);
		}
			
	}
	
	
	

	}

