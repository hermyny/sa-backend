package dev.hermyny.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category findByTitle(String title);

}
