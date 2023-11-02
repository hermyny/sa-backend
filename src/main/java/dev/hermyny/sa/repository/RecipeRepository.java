package dev.hermyny.sa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	Recipe findByName(String name);
	
	Recipe findByBudget(String budget);
	
	Recipe findByDifficulty(String difficulty);
	
	List<Recipe> findByCountry(Integer country_id);
	
	List<Recipe> findByCategory(Integer category_id);
	
	
}
