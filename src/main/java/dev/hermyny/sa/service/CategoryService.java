package dev.hermyny.sa.service;

import java.util.List;

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
	
	
    public List<Category> search() { return this.categoryRepository.findAll(); }
	
	
	public Category readOrCreate(Category categoryToAdd) {
		Category categoryInBdd = this.categoryRepository.findByTitle(categoryToAdd.getTitle());
		if(categoryInBdd == null ) {
		categoryInBdd = this.categoryRepository.save(categoryToAdd);
	
		}
		
		return categoryInBdd;
		
	}

}
