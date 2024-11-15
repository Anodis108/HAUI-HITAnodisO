package com.example.projectbase.exception;

/**
 * The type Username already exists exception.
 */
public class UsernameAlreadyExistsException extends RuntimeException {
    /**
     * Instantiates a new Username already exists exception.
     *
     * @param message the message
     */
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
