package dev.hermyny.sa.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import dev.hermyny.sa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
	
}
