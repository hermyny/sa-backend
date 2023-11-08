package dev.hermyny.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

	
	Country findByName(String name);
	
	
}
