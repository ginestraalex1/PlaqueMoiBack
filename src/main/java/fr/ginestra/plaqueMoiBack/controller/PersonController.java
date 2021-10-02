package fr.ginestra.plaqueMoiBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ginestra.plaqueMoiBack.model.Person;
import fr.ginestra.plaqueMoiBack.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@GetMapping("/persons")
	private Iterable<Person> getPersons(){
		return personService.getPersons();
	}
	
}
