package com.calculator.price.validation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Storing type and reason for validation purpose
 */
@Getter
public class ValidationMessage {

    private ErrorType type;
    private String reason;
    private String field;
    @JsonIgnore
    private List<ValidationMessage> errors = new ArrayList<>();

    public ValidationMessage(ErrorType type) {
        this.type = type;
        this.reason = type.getReason();
        this.field = type.getField();
    }
}
