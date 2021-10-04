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
public class FriendRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID uuidRequest;
	private Date requestDate;
	private String emitterUsername;
	private String plateNumber;
	private boolean treated;
	private boolean canceled;
	
	public UUID getUuidRequest() {
		return uuidRequest;
	}
	public void setUuidRequest(UUID uuidRequest) {
		this.uuidRequest = uuidRequest;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getEmitterUsername() {
		return emitterUsername;
	}
	public void setEmitterUsername(String emitterUsername) {
		this.emitterUsername = emitterUsername;
	}
	public boolean isTreated() {
		return treated;
	}
	public void setTreated(boolean treated) {
		this.treated = treated;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	

	public String toString() {
		return "Conversation:{uuidRequest : " + this.uuidRequest + ", " +
				"requestDate : " + this.requestDate + ", " +
				"emitterUsername : " + this.emitterUsername + ", " +
				"plateNumber : " + this.plateNumber + ", " +
				"treated : " + this.treated + ", " +
				"canceled : " + this.canceled + "}";
	}
	
}
