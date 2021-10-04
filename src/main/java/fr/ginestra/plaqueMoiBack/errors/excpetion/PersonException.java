package fr.ginestra.plaqueMoiBack.errors.excpetion;

import org.springframework.http.HttpStatus;

import fr.ginestra.plaqueMoiBack.errors.list.PersonError;

public class PersonException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;

	public PersonException(PersonError error) {
		super(error.getMessage());
		this.httpStatus = error.getHttpStatus();
	}
	
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}

}
