package com.educaciencia.demo.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resurce Not Found - for ID NUMBER " + id); //mensagem de retorno
	}
}
