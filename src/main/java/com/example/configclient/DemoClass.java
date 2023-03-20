package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void postConstruct(){
        System.out.println("This is postconstruct method ");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("This is application ready event listener");
    }

    @EventListener
    public void allApplicationEventListener(ApplicationEvent event) {
        System.out.println("event: "+event.getClass());
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            System.out.println("this is the run method of command line runner and we've created a bean of it");
        };
    }

    @Bean
    public ApplicationRunner applicationRunner(ApplicationArguments args0){
        return args -> {
            System.out.println("application runner bean created");
            System.out.println("args0: "+args0.getSourceArgs());
        };
    }
}
