package br.com.supplyradar.domain.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;


public class UsuarioJaExisteException extends ValidationException {
    public UsuarioJaExisteException(ValidationResult validationResult) {
        super(validationResult);
    }
}
