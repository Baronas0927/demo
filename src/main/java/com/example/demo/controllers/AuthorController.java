package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Iterable<Author> getAllAuthors(){
        return authorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Optional<Author> author = authorService.findById(id);
        if(author.isPresent()){
            return ResponseEntity.ok(author.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails){
        Optional<Author> author = authorService.findById(id);
        if(author.isPresent()){
            Author updatedAuthor = author.get();
            updatedAuthor.setName(authorDetails.getName());
            updatedAuthor.setSurname(authorDetails.getSurname());
            return ResponseEntity.ok(authorService.save(updatedAuthor));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}