package org.example.backend101.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BadRequestException extends Exception{
    private static final long serialVersionUID = 1L;

    public BadRequestException(String msg) {
        super(msg);
    }
}
