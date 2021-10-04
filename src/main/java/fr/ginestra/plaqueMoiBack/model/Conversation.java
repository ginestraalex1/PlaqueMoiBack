package fr.ginestra.plaqueMoiBack.model;

import java.util.UUID;

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
	private UUID uuidConversation;
	private String conversationName;
	private String[] participantsUsername;
	

	public UUID getUuidConversation() {
		return uuidConversation;
	}

	public void setUuidConversation(UUID uuidConversation) {
		this.uuidConversation = uuidConversation;
	}

	public String getConversationName() {
		return conversationName;
	}

	public void setConversationName(String conversationName) {
		this.conversationName = conversationName;
	}

	public String[] getParticipantsUsername() {
		return participantsUsername;
	}

	public void setParticipantsUsername(String[] participantsUsername) {
		this.participantsUsername = participantsUsername;
	}
	
	public UUID generateUuidConversation() {
		if(this.uuidConversation == null) {
			this.uuidConversation = UUID.randomUUID();
			return this.uuidConversation;
		}
		return null;
	}
}
