package fr.ginestra.plaqueMoiBack.service;

import lombok.Data;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ginestra.plaqueMoiBack.model.Conversation;
import fr.ginestra.plaqueMoiBack.repository.ConversationRepository;


@Data
@Service
public class ConversationService {

	
    @Autowired
    private ConversationRepository conversationRepository;
    
    public Conversation getConversation(UUID id) {
        return conversationRepository.findById(id).get();
    }

    public Iterable<Conversation> getConversations() {
        return conversationRepository.findAll();
    }

    public void deleteConversation(UUID id) {
    	conversationRepository.deleteById(id);
    }

    public Conversation saveConversation(Conversation conversation) {
    	System.out.println(conversation);
    	Conversation savedConversation = conversationRepository.save(conversation);
        return savedConversation;
    }
    
    public Conversation updateConversation(UUID id, Conversation updatedConversation) {
    	Optional<Conversation> conversation = conversationRepository.findById(id);
    	if(conversation.isEmpty()) {
    		return conversationRepository.save(updatedConversation);
    	}
    	return conversationRepository.save(conversation.get().updateConversation(updatedConversation));
    }
}
