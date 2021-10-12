package fr.ginestra.plaqueMoiBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ginestra.plaqueMoiBack.errors.excpetion.PersonException;
import fr.ginestra.plaqueMoiBack.model.Person;
import fr.ginestra.plaqueMoiBack.service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@GetMapping()
	private Iterable<Person> getPersons(){
		return personService.getPersons();
	}
	
	@PostMapping()
	private ResponseEntity<String> createPerson(@RequestBody Person newPerson) {
		try {
			personService.savePerson(newPerson);
		}
		catch(PersonException e) {
			System.out.println(e);
			return new ResponseEntity<String>(e.getMessage(), e.getHttpStatus());
		}
		
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
	
}
