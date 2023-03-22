package com.example.configclient.exceptionhandler;

import com.example.configclient.exception.GenericExceptionClass;
import com.example.configclient.exception.Sample404ExceptionClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Sample404ExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleSample404Exception(Sample404ExceptionClass e) {
        log.info("handling Sample404 Exception using Exception handler");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(GenericExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleSampleGenericException(GenericExceptionClass e) {
        log.info("handling Generic Exception using Exception handler");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new HashMap<>(){{
                    put("error_msg", "This is a generic exception");
                }});
    }
}
