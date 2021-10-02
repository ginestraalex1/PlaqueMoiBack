package fr.ginestra.plaqueMoiBack.repository;

import org.springframework.stereotype.Repository;
import fr.ginestra.plaqueMoiBack.model.Person;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
