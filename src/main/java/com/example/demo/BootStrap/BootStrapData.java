package com.example.demo.bootstrap;

import com.example.demo.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final Logger logger = LoggerFactory.getLogger(BootStrapData.class);

    public BootStrapData(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("labas");
//        System.out.println(authorRepository.findById(1l));
//        System.out.println(authorRepository.findAll());

    }
}