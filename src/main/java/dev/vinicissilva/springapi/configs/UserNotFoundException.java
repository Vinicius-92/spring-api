package dev.vinicissilva.springapi.configs;

public class UserNotFoundException extends RuntimeException {
    private static final String message = "User not found";
    public UserNotFoundException() {
        super(message);
    }
}
