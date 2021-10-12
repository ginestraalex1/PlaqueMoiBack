package fr.ginestra.plaqueMoiBack.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ginestra.plaqueMoiBack.model.Message;
import fr.ginestra.plaqueMoiBack.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	
	@Autowired
	private MessageService messageService;
	
	@GetMapping()
	private Iterable<Message> getMessages(){
		return messageService.getMessages();
	}
	
	@GetMapping("{id}")
	public Message getMessage(@PathVariable("id") UUID id) {
		return this.messageService.getMessage(id);
	}
	
	@PostMapping()
	public Message createMessage(@RequestBody Message message) {
		return this.messageService.saveMessage(message);
	}
}
