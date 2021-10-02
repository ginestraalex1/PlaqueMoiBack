package fr.ginestra.plaqueMoiBack.repository;

import org.springframework.stereotype.Repository;
import fr.ginestra.plaqueMoiBack.model.Conversation;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long>{

}
