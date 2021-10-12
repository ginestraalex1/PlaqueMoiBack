package fr.ginestra.plaqueMoiBack.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ginestra.plaqueMoiBack.model.Message;
import fr.ginestra.plaqueMoiBack.repository.MessageRepository;
import lombok.Data;

@Data
@Service
public class MessageService {
	

    @Autowired
    private MessageRepository messageRepository;
    
    public Message getMessage(UUID id) {
        return messageRepository.findById(id).get();
    }

    public Iterable<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void deleteMessage(UUID id) {
    	messageRepository.deleteById(id);
    }

    public Message saveMessage(Message message) {
    	Message savedMessage = messageRepository.save(message);
        return savedMessage;
    }

}
