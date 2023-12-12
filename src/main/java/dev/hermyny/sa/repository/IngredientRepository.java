package dev.hermyny.sa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

	Ingredient findByName(String name);
	
	Ingredient findByType(String type);
	
	Ingredient findByCalorie(int calorie);
	
	
}
