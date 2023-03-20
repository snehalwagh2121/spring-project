package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoClass {

    @Value("${excel.file.location}")
    String filePath;
    
    @Value("${message}")
    String message;

    @GetMapping("/")
    public String getFilePath(){
        System.out.println("file : "+filePath);
        System.out.println("message: "+message);
        return message;
    }

}
