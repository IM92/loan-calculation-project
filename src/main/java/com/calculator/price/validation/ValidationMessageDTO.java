package com.calculator.price.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationMessageDTO {

    private String type;
    private String reason;
    private String field;
    private List<ValidationMessageDTO> errors = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<ValidationMessageDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationMessageDTO> errors) {
        this.errors = errors;
    }
}
