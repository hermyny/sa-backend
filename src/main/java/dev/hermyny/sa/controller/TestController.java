package dev.hermyny.sa.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

	

	

	

	@GetMapping
	public List<String> getList() {
		return List.of("Chaine de caractères" ,"affichée par Hermancia" ,"je suis trop balèze");
	}
	
	@GetMapping(path = "/string")
	public String getString() {
		return " Chaine de caractères affichée par Hermancia";
	}
	
	
}


