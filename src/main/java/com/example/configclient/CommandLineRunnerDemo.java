package com.example.configclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is the run method of command line runner and we've created a new class implementing the CommandLineRunner interface");
    }

    @PostConstruct
    private void message(){
        System.out.println("Command Line Runner Demo object created");
    }
}
