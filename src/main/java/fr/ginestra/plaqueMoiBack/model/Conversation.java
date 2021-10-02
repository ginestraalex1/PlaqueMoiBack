package fr.ginestra.plaqueMoiBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Conversation {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@org.hibernate.annotations.Type(type="uuid-char")
	private String uuidConversation;
	private String conversationName;
	private String[] participantsUsername;
	
}
