package fr.ginestra.plaqueMoiBack.controller;

import fr.ginestra.plaqueMoiBack.model.Conversation;
import fr.ginestra.plaqueMoiBack.service.ConversationService;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

	@Autowired
	private ConversationService conversationService;
	
	
	/**
    * Read - Get all conversations
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping()
    public Iterable<Conversation> getConversations() {
    	System.out.println("on est dans get conv");
        return conversationService.getConversations();
    }
    
    @PostMapping()
    public Conversation createConversation(@RequestBody Conversation newConversation) {
    	System.out.println("on est dans create conv");
    	return conversationService.saveConversation(newConversation);
    }
    
    @GetMapping("/{id}")
    public Conversation getConversation(@PathVariable("id") UUID conversationId) {
    	System.out.println("on est dans get conv");
    	return conversationService.getConversation(conversationId);
    }

    @PutMapping("/{id}")
    public Conversation updateConversation(@PathVariable("id") int id, @RequestBody Conversation updatedConversation) {
    	System.out.println("on est dans update conv");
    	return conversationService.saveConversation(updatedConversation);
    }
}
