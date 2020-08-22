package com.calculator.price.exceptions;

import com.calculator.price.validation.ValidationResponseDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CoreInvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseDTO handleException(CoreInvalidDataException e) {

        LOG.error("Unexpected error: ", e);
        return new ExceptionResponseDTO(new ErrorStatus(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ComplexExceptionResponseDTO handleValidationException(ValidationException e) {

        LOG.info("Validation failed: ", e);
        return new ComplexExceptionResponseDTO(
                ValidationResponseDTOMapper.map(e.getValidation()),
                e.getMessage(),
                new ErrorStatus(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(value = {CreateLoanInfoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseDTO handleStripeException(CreateLoanInfoException e) {
        LOG.error("Unexpected error: Validation Exception while creating loan info");
        ErrorStatus errorStatus = new ErrorStatus(HttpStatus.FORBIDDEN.value(), "Validation Exception");
        return new ExceptionResponseDTO(e.getValidation().getErrors(), errorStatus);
    }
}
