package com.calculator.price.exceptions;

import com.calculator.price.validation.Validation;

public class ValidationException extends RuntimeException {

    private Validation validation;

    public ValidationException(Validation validation) {
        this.validation = validation;
    }

    public Validation getValidation() {
        return validation;
    }
}
