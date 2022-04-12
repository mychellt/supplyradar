package br.com.supplyradar.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestControllerExceptionHandler {
    @ExceptionHandler
    ResponseEntity<Object> handleException(final Exception ex, final WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }
}
