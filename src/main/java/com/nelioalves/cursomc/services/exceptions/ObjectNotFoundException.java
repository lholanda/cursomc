package com.nelioalves.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	// outra sobrecarga que recebe alem da msg a causa da execao
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
