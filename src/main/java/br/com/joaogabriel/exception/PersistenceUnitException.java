package br.com.joaogabriel.exception;

public class PersistenceUnitException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PersistenceUnitException(String message) {
		super(message);
	}

}
