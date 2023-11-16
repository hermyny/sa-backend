package dev.hermyny.sa.service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.hermyny.sa.RoleType;
import dev.hermyny.sa.model.Category;
import dev.hermyny.sa.model.Continent;
import dev.hermyny.sa.model.Country;
import dev.hermyny.sa.model.Recipe;
import dev.hermyny.sa.model.Role;
import dev.hermyny.sa.model.User;
import dev.hermyny.sa.model.Validation;
import dev.hermyny.sa.repository.UserRepository;



@Service
public class UserService { 
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder;
	private RecipeService recipeService;
	private ValidationService validationService;
	
	
	

	public UserService(UserRepository userRepository,ValidationService validationService, BCryptPasswordEncoder passwordEncoder, RecipeService recipeService) {
		
		this.userRepository = userRepository;
		this.recipeService = recipeService;
		this. passwordEncoder = passwordEncoder;
		this.validationService  = validationService;
	}
	
	
	public void create(User user) {
		if(!user.getEmail().contains("@")) {
			throw new RuntimeException("Votre email est invalide");
		}
		if(!user.getEmail().contains(".")) {
			throw new RuntimeException("Votre email est invalide");
		}
		Optional<User> userOptional = this.userRepository.findByEmail(user.getEmail());
		if(userOptional.isPresent()) {
			throw new RuntimeException("Votre email est déja utilisé. Veuillez en changer.");
		}
		Role roleUser = new Role();
		roleUser.setName(RoleType.VISITOR);
		user.setRole(roleUser);
		
		String password = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user = this.userRepository.save(user);
		this.validationService.registrate(user);
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
	
	
	public void updateUser(int id, User user) {
		User userInBdd = this.readOrCreateById(id);
		if (userInBdd.getId() != user.getId()) {
			userInBdd.setName(user.getName());
			userInBdd.setPseudo(user.getPseudo());
			userInBdd.setEmail(user.getEmail());
			userInBdd.setPassword(user.getPassword());

			this.userRepository.save(userInBdd);
		}
			
	}
	
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElse(null);
		   if (user != null) {
			   this.userRepository.deleteById(id);
		   } else {
			   throw new RuntimeException("Le pays numéro" + id + " est introuvable");
		   }
		}


	public void activation(Map<String, String> activation) {
		Validation validation = this.validationService.readByCode(activation.get("code"));
		if(Instant.now().isAfter(validation.getExpire())) {
			
			throw new RuntimeException("Votre code a expiré");
		}
		
		
		User userActive = this.userRepository.findById(validation.getUser().getId())
			    .orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
		userActive.setActive(true);
		this.userRepository.save(userActive);
		
	}


	
	
	
	
	
}

