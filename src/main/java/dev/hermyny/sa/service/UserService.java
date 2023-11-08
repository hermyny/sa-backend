package dev.hermyny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.hermyny.sa.model.Recipe;
import dev.hermyny.sa.model.User;
import dev.hermyny.sa.repository.UserRepository;


@Service
public class UserService { 
	
	private UserRepository userRepository;
	private RecipeService recipeService;
	
	

	public UserService(UserRepository userRepository, RecipeService recipeService) {
		
		this.userRepository = userRepository;
		this.recipeService = recipeService;
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
	
	
	public User readOrCreateById(int id) {
		Optional<User> optionalClient = this.userRepository.findById(id);
		if(optionalClient.isPresent()) {
			return optionalClient.orElse(null);
		
		}
		return null;
	}
	
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElse(null);
		   if (user != null) {
			   this.userRepository.deleteById(id);
		   } else {
			   throw new RuntimeException("Le pays numéro" + id + " est introuvable");
		   }
		}


	
	
	
	
	
}

