package fr.ginestra.plaqueMoiBack.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID uuidMessage;
	private Date sentDate;
	private String emitterUsername;
	private String conversationUuid;
	private String message;
	
	public UUID getUuidMessage() {
		return uuidMessage;
	}
	public void setUuidMessage(UUID uuidMessage) {
		this.uuidMessage = uuidMessage;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public String getEmitterUsername() {
		return emitterUsername;
	}
	public void setEmitterUsername(String emitterUsername) {
		this.emitterUsername = emitterUsername;
	}
	public String getConversationUuid() {
		return conversationUuid;
	}
	public void setConversationUuid(String conversationUuid) {
		this.conversationUuid = conversationUuid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
