package fr.ginestra.plaqueMoiBack.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public String getUuidRequest() {
		return uuidRequest;
	}
	public void setUuidRequest(String uuidRequest) {
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
	
}
