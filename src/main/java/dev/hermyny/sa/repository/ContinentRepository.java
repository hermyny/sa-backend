package dev.hermyny.sa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {

	
	Continent findByName(String name);
	
	
}
