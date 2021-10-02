package fr.ginestra.plaqueMoiBack.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FriendRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String uuidRequest;
	private Date requestDate;
	private String emitterUsername;
	private boolean treated;
	private String plateNumber;
	private boolean canceled;
	
}
