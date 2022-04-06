package br.com.supplyradar.domain.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;


public class MandatoryFieldException extends ValidationException {
    public MandatoryFieldException(ValidationResult validationResult) {
        super(validationResult);
    }
}
