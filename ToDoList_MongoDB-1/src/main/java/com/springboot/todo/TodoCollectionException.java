package com.springboot.todo;

public class TodoCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TodoCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "To do with " + id + " not found";	
	}
	
	public static String allreadyExists() {
		return "Todo with given name already exists....";
	}
}
