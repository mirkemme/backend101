package org.example.backend101.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus
public class InvalidInputException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidInputException(String msg) {
        super(msg);
    }
}
