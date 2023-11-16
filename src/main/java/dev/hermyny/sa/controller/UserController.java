package dev.hermyny.sa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.hermyny.sa.model.User;
import dev.hermyny.sa.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(path = "user" , consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}



	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user) {
		this.userService.create(user);
		
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "activation", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void activate(@RequestBody Map<String,String> activation) {
		this.userService.activation(activation);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> search() {
		return this.userService.search();
		
	}
	
	
	@GetMapping(path = "read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User readOrCreateById(@PathVariable int id) {
		return this.userService.readOrCreateById(id);
		
	}
	
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable int id, @RequestBody User user) {
    	
    	this.userService.updateUser(id, user);
    }
	
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable int id) {
		
		this.userService.deleteUser(id);
	}
	
	
	
	
}
