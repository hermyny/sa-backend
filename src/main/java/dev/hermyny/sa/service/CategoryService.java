package dev.hermyny.sa.service;

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
		this.categoryRepository.save(category);
		 
	 }

}
