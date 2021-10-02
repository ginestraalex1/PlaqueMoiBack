package fr.ginestra.plaqueMoiBack.controller;

import fr.ginestra.plaqueMoiBack.model.Conversation;
import fr.ginestra.plaqueMoiBack.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversationController {

	@Autowired
	private ConversationService conversationService;
	
	
	/**
    * Read - Get all conversations
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/conversations")
    public Iterable<Conversation> getEmployees() {
        return conversationService.getConversations();
    }
}
