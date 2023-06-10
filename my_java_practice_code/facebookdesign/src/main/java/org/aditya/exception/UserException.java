package org.aditya.exception;

public class UserException extends RuntimeException {



    private final String message;
    public UserException(String message) {
//        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
