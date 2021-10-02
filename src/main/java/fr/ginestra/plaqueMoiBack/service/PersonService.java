package fr.ginestra.plaqueMoiBack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ginestra.plaqueMoiBack.model.Person;
import fr.ginestra.plaqueMoiBack.repository.PersonRepository;
import lombok.Data;

@Data
@Service
public class PersonService {
	

    @Autowired
    private PersonRepository personRepository;
    
    public Optional<Person> getPerson(final Long id) {
        return personRepository.findById(id);
    }

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(final Long id) {
    	personRepository.deleteById(id);
    }

    public Person savePerson(Person person) {
    	Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

}
