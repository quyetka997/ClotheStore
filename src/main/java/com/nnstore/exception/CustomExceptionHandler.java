package com.nnstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest request) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest request) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

}
