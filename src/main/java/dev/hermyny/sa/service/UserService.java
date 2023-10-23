package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.hermyny.sa.model.User;
import dev.hermyny.sa.repository.UserRepository;

@Service
public class UserService { 
	
	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void create(User user) {
		User userInBdd = this.userRepository.findByEmail(user.getEmail());
		if(userInBdd == null) {
		this.userRepository.save(user);
		}
	}
	
	
	public List<User> search(){
		return this.userRepository.findAll();
	}
	
	
	public User read(int id) {
		Optional<User> optionalClient = this.userRepository.findById(id);
		if(optionalClient.isPresent()) {
			return optionalClient.orElse(null);
		
		}
		return null;
	}
}
