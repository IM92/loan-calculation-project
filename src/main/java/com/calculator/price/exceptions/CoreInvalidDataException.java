package com.calculator.price.exceptions;

public class CoreInvalidDataException extends RuntimeException {

    private static final long serialVersionUID = 1303405808304830421L;

    public CoreInvalidDataException() {
        super();
    }

    public CoreInvalidDataException(final String message) {
        super(message);
    }

    public CoreInvalidDataException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CoreInvalidDataException(final Throwable cause) {
        super(cause);
    }
}