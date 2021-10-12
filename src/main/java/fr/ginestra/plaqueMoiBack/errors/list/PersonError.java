package fr.ginestra.plaqueMoiBack.errors.list;

import org.springframework.http.HttpStatus;

public enum PersonError {
	
	ALREADY_EXIST("{ \"Error \" : \"The plate number is already used.\" }", HttpStatus.INTERNAL_SERVER_ERROR); 

	private final String message;
	private final HttpStatus httpStatus;
	
	PersonError(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
}
