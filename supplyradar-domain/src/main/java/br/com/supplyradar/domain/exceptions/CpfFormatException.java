package br.com.supplyradar.domain.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;



public class CpfFormatException extends ValidationException {
    public CpfFormatException(ValidationResult validationResult) {
        super(validationResult);
    }
}
