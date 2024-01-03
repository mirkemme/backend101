package org.example.backend101.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NoContentException.class })
    protected ResponseEntity<Object> handleNoContentException(
            NoContentException exception, WebRequest request) {
        ErrorMessage bodyOfResponse = new ErrorMessage(
                HttpStatus.NO_CONTENT.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @ExceptionHandler(value = { InvalidInputException.class })
    protected ResponseEntity<Object> handleBadRequestException(
            InvalidInputException exception, WebRequest request) {
        ErrorMessage bodyOfResponse = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false));

        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}