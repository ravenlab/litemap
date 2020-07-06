package com.github.ravenlab.litemap.exception;

public class MissingPropertyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 815536848188810659L;
	
	public MissingPropertyException(String property) {
		super("Missing property '" + property + "' from configured database");
	}
}