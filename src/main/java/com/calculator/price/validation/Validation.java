package com.calculator.price.validation;

import com.calculator.price.exceptions.ValidationException;

import java.util.Collections;
import java.util.List;

/**
 * Object for storing customer validation messages
 */
public class Validation {

    private boolean valid;
    private List<ValidationMessage> errors;

    public Validation(boolean valid, List<ValidationMessage> errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public static Validation create(List<ValidationMessage> messages) {
        return new Validation(messages.isEmpty(), messages);
    }

    public static Validation createValid() {
        return new Validation(true, Collections.emptyList());
    }

    public static Validation createInvalid(List<ValidationMessage> messages) {
        return new Validation(false, messages);
    }

    public static Validation createInvalid(ValidationMessage message) {
        return new Validation(false, Collections.singletonList(message));
    }

    public boolean isValid() {
        return valid;
    }

    public List<ValidationMessage> getErrors() {
        return errors;
    }

    public Validation validate() {
        if (this.isValid()) {
            return this;
        } else {
            throw new ValidationException(this);
        }
    }
}
