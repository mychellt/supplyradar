package br.com.supplyradar.domain.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;


public class BusinessException extends ValidationException {
    public BusinessException(ValidationResult validationResult) {
        super(validationResult);
    }
}
