package fr.ginestra.plaqueMoiBack.model;


import javax.persistence.Id;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Person {
	
	@Id
	private String plateNumber;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String toString() {
		return "Conversation:{plateNumber : " + this.plateNumber + ", " +
				"userName : " + this.userName + ", " +
				"firstName : " + this.firstName + ", " +
				"lastName : " + this.lastName + ", " +
				"email : " + this.email + ", " +
				"role : " + this.role + ", " +
				"password : " + this.password + "}";
	}
}
