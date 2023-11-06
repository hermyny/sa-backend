package dev.hermyny.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.hermyny.sa.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category findByTitle(String title);

	@Modifying
	@Query("update Category u set u.title = :title where u.id = :id")
	void updateCategoryById(@Param(value = "id") int id, @Param(value = "title") String title);

}
