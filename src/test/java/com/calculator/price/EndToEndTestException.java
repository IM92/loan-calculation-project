package com.calculator.price;

public class EndToEndTestException extends RuntimeException {
    public EndToEndTestException(String message) {
        super(message);
    }
    public EndToEndTestException(String message, Throwable cause) {
        super(message, cause);
    }
}
