package fr.ginestra.plaqueMoiBack.model;

import java.util.Date;

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
	private String uuidMessage;
	private Date sentDate;
	private String emitterUsername;
	private String conversationUuid;
	private String message;
}
