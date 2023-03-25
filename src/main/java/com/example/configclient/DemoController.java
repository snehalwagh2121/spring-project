package com.example.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DemoController {

    Logger log = LoggerFactory.getLogger(DemoController.class);
    @Value("${excel.file.location}")
    String filePath;

    @Value("${message}")
    String message;

    @GetMapping("/")
    public String getFilePath() {
        log.info("file : " + filePath);
        log.info("message: " + message);
        return message;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("This is postconstruct method ");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("This is application ready event listener");
    }

    @EventListener
    public void allApplicationEventListener(ApplicationEvent event) {
        log.info("event: " + event.getClass());
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            log.info("this is the run method of command line runner and we've created a bean of it");
        };
    }

    @Bean
    public ApplicationRunner applicationRunner(ApplicationArguments args0) {
        return args -> {
            log.info("application runner bean created");
            log.info("args0: " + args0.getSourceArgs());
        };
    }
}
