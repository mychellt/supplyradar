package br.com.supplyradar.domain.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;


public class ObjectNotFoundException extends ValidationException {
    public ObjectNotFoundException(ValidationResult validationResult) {
        super(validationResult);
    }
}
