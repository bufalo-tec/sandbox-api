package com.br.bufalo.template.error;

import java.util.Optional;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private final HttpStatus status;
    private final String errorMessage;

    public CustomException(HttpStatus status, String errorMessage) {
        super();
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Optional<String> getErrorMessage() {
        return Optional.of(this.errorMessage);
    }
}
