package dev.hermyny.sa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hermyny.sa.model.Validation;




public interface ValidationRepository extends CrudRepository<Validation, Integer>{
  
	
	Optional<Validation> findByCode(String  code);
	
}
