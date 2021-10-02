package fr.ginestra.plaqueMoiBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ginestra.plaqueMoiBack.model.Message;
import fr.ginestra.plaqueMoiBack.service.MessageService;

@RestController
public class MessageController {

	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messages")
	private Iterable<Message> getMessages(){
		return messageService.getMessages();
	}
}
