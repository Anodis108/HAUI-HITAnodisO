package com.example.projectbase.exception;

/**
 * The type User already has this profile.
 */
public class UserAlreadyHasThisProfile extends RuntimeException {
    /**
     * Instantiates a new User already has this profile.
     *
     * @param message the message
     */
    public UserAlreadyHasThisProfile(String message) {
        super(message);
    }
}
