package fr.ginestra.plaqueMoiBack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userName;
	private String firstName;
	private String lastName;
	private String plateNumber;
	private String email;
	private String password;
}
