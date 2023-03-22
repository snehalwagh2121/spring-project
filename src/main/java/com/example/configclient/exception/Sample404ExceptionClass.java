package com.example.configclient.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Slf4j
public class Sample404ExceptionClass extends RuntimeException {
    public Sample404ExceptionClass(String msg) {
        super(msg);
    }
}
