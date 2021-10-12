package fr.ginestra.plaqueMoiBack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ginestra.plaqueMoiBack.errors.excpetion.PersonException;
import fr.ginestra.plaqueMoiBack.errors.list.PersonError;
import fr.ginestra.plaqueMoiBack.model.Person;
import fr.ginestra.plaqueMoiBack.repository.PersonRepository;
import lombok.Data;

@Data
@Service
public class PersonService {
	

    @Autowired
    private PersonRepository personRepository;
    
    public Optional<Person> getPerson(String plateNumber) {
        return personRepository.findById(plateNumber);
    }

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(String plateNumber) {
    	personRepository.deleteById(plateNumber);
    }

    public Person savePerson(Person person) throws PersonException{
    	if(!personRepository.findById(person.getPlateNumber()).isEmpty()) {
    		throw new PersonException(PersonError.ALREADY_EXIST);
    	}
    	Person savedPerson = personRepository.save(person);
        return savedPerson;	
    }
}
