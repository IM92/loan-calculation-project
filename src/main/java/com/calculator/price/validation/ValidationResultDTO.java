package com.calculator.price.validation;

import java.util.Collections;
import java.util.List;

public class ValidationResultDTO {

    private boolean valid;
    private List<ValidationMessageDTO> errors;

    public static ValidationResultDTO createValid() {
        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
        validationResultDTO.setValid(true);
        validationResultDTO.setErrors(Collections.emptyList());
        return validationResultDTO;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<ValidationMessageDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationMessageDTO> errors) {
        this.errors = errors;
    }
}
