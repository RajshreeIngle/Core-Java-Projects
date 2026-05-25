package com.emppayroll;

public class DuplicateIdException extends Exception {
	
	public DuplicateIdException(String message) {
        // Passing the custom error message to the parent Exception
        super(message);
    }

}
