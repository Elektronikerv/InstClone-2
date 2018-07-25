package com.inst.exception;


public class NoAccessException extends RuntimeException {
    public NoAccessException() {
        super();
    }

    public NoAccessException(String message) {
        super(message);
    }
}
