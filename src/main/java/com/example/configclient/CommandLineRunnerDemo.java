package com.example.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    Logger log = LoggerFactory.getLogger(CommandLineRunnerDemo.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("This is the run method of command line runner and we've created a new class implementing the CommandLineRunner interface");
    }

    @PostConstruct
    private void message() {
        log.info("Command Line Runner Demo object created");
    }
}
