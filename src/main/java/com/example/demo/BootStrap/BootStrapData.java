package com.example.demo.BootStrap;

import com.example.demo.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    public BootStrapData(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("labas");
    }
}
