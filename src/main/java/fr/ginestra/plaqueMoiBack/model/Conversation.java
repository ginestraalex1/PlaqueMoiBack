package fr.ginestra.plaqueMoiBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conversation {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@org.hibernate.annotations.Type(type="uuid-char")
	private String uuidConversation;
	private String conversationName;
	private String[] participantsUsername;
	
	
	public String getUuidConversation() {
		return uuidConversation;
	}
	public void setUuidConversation(String uuidConversation) {
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
}
