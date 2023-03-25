package com.example.configclient;

import com.example.configclient.exception.GenericExceptionClass;
import com.example.configclient.exception.Sample404ExceptionClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    Logger logger= LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping("/sample404")
    public String throwException(){
        logger.info("throwing an exception now");
        throw new Sample404ExceptionClass("This is a sample exception");
    }
    @GetMapping("/generic")
    public String throwGenericException() throws GenericExceptionClass {
        logger.info("throwing generic exception now");
        throw new GenericExceptionClass("This is a sample GENERIC exception");
    }
}
