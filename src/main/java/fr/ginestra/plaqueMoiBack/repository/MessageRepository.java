package fr.ginestra.plaqueMoiBack.repository;

import org.springframework.stereotype.Repository;
import fr.ginestra.plaqueMoiBack.model.Message;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
