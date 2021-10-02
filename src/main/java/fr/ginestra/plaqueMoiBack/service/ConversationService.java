package fr.ginestra.plaqueMoiBack.service;

import lombok.Data;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ginestra.plaqueMoiBack.model.Conversation;
import fr.ginestra.plaqueMoiBack.repository.ConversationRepository;


@Data
@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    
    public Optional<Conversation> getConversation(final Long id) {
        return conversationRepository.findById(id);
    }

    public Iterable<Conversation> getConversations() {
        return conversationRepository.findAll();
    }

    public void deleteConversation(final Long id) {
    	conversationRepository.deleteById(id);
    }

    public Conversation saveConversation(Conversation conversation) {
    	Conversation savedConversation = conversationRepository.save(conversation);
        return savedConversation;
    }
    
}
