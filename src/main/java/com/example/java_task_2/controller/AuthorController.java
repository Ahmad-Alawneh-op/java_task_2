package com.example.java_task_2.controller;

import com.example.java_task_2.data.Author;
import com.example.java_task_2.data.SimpleJsonResponse;
import com.example.java_task_2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/byId")
    public Author getAuthorByEmail(@RequestParam(defaultValue = "") String id) {
        return authorService.getAuthor(id);
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleJsonResponse> createAuthor (@RequestBody Author author) {
        boolean isSuccessful = authorService.addAuthor(author);

        if (isSuccessful) {
            SimpleJsonResponse successfulResponse
            return new ResponseEntity<>(new SimpleJsonResponse("created successfully", 200, false), new HttpHeaders(), HttpStatus.CREATED);
        }
    }
}
