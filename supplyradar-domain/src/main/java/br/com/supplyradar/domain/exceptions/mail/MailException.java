package br.com.supplyradar.domain.exceptions.mail;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.supplyradar.domain.exceptions.DomainException;

import java.util.List;

public class MailException extends DomainException {

	public MailException(final ValidationResult validationResult) {
		super(validationResult);
	}

	public MailException(final String message) {
		super(ValidationResult.fail(List.of(Error.create("", message, "500", ""))));
	}
}
