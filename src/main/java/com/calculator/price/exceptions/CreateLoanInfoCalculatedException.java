package com.calculator.price.exceptions;

import com.calculator.price.validation.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLoanInfoCalculatedException extends RuntimeException {
   private Validation validation;
}
