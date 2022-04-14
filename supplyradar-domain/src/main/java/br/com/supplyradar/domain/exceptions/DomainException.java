package br.com.supplyradar.domain.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;


public class DomainException extends ValidationException {
    public DomainException(ValidationResult validationResult) {
        super(validationResult);
    }
}
