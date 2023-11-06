package dev.hermyny.sa.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	Recipe findByName(String name);
	
	Recipe findByBudget(String budget);
	
	Recipe findByDifficulty(String difficulty);
	
	
	
	
	
}
