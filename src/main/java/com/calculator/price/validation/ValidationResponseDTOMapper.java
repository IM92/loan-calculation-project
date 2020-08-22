package com.calculator.price.validation;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidationResponseDTOMapper {
    private ValidationResponseDTOMapper() {}

    public static ValidationResultDTO map(Validation validation) {

        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
        validationResultDTO.setValid(validation.isValid());

        List<ValidationMessageDTO> collect = validation.getErrors().stream().map(getMapper()).collect(Collectors.toList());

        validationResultDTO.setErrors(collect);

        return validationResultDTO;
    }

    private static Function<ValidationMessage, ValidationMessageDTO> getMapper() {
        return message -> {
            ValidationMessageDTO messageDTO = new ValidationMessageDTO();
            messageDTO.setField(message.getField());
            messageDTO.setReason(message.getReason());
            messageDTO.setType(message.getType().getType());
            List<ValidationMessageDTO> messageDTOS = message.getErrors().stream().map(getMapper()).collect(Collectors.toList());
            messageDTO.setErrors(messageDTOS);
            return messageDTO;
        };
    }
}
