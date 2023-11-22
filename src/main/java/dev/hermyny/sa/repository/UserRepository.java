package dev.hermyny.sa.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);
	
	
	


//	Optional<User> findByPseudo(String pseudo);
	
	
}
