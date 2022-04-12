package br.com.supplyradar.configuration;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.transform.ValidationResultTransform;
import br.com.supplyradar.core.response.ErrorField;
import br.com.supplyradar.core.response.ErrorResponse;
import br.com.supplyradar.domain.exceptions.MandatoryFieldException;
import br.com.supplyradar.domain.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayDeque;

@RestControllerAdvice
public class RestControllerExceptionHandler {



    @ExceptionHandler
    ResponseEntity<Object> handleException(final HttpMessageNotReadableException ex) {
        final ErrorResponse errorResponse = ErrorResponse.builder().message("Requisição inválida").code(HttpStatus.BAD_REQUEST.value()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    ResponseEntity<Object> handleException(final ObjectNotFoundException ex) {
        final ErrorResponse errorResponse = ErrorResponse.builder().message("Recurso não encontrado").code(HttpStatus.NOT_FOUND.value()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    ResponseEntity<Object> handleException(final MandatoryFieldException ex) {
        final ErrorResponseTransformation errorResponseTransformation = new ErrorResponseTransformation(HttpStatus.BAD_REQUEST.value(), "Campo(os) obrigatório(os) não informados");
        final ErrorResponse errorResponse = errorResponseTransformation.transform(ex.getValidationResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


    @AllArgsConstructor
    static class ErrorResponseTransformation implements ValidationResultTransform<ErrorResponse> {
        private final int code;
        private final String message;

        @Override
        public ErrorResponse transform(ValidationResult validationResult) {
            final ErrorResponse.ErrorResponseBuilder errorResponseBuilder = ErrorResponse.builder();
            errorResponseBuilder.message(message);
            errorResponseBuilder.code(code);
            errorResponseBuilder.fields(new ArrayDeque<>());
            final ErrorResponse errorResponse = errorResponseBuilder.build();

            for(final Error error : validationResult.getErrors()) {
                final ErrorField errorField = ErrorField.builder().field(error.getField())
                        .value(error.getAttemptedValue())
                        .message(error.getMessage())
                        .build();
                errorResponse.getFields().add(errorField);
            }

            return  errorResponse;
        }
    }
}
