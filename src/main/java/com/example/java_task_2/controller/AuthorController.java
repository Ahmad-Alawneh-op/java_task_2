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
import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/byId")
    public Author getAuthorById(@RequestParam(defaultValue = "") String id) {
        return authorService.getAuthor(id);
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleJsonResponse> createAuthor (@RequestBody Author author) {
        try {
            author.setId(UUID.randomUUID().toString());
            authorService.addAuthor(author);
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Author created successfully: " + author.getId(), 201, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<SimpleJsonResponse> updateAuthor (@RequestBody Author author) {
        if (author.getId() == null) {
            SimpleJsonResponse noIdResponse = new SimpleJsonResponse("Id must be provided", 200, true);

            return new ResponseEntity<>(noIdResponse, new HttpHeaders(), HttpStatus.OK);
        }
        try {
            authorService.updateAuthor(author);
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Author updated successfully", 200, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SimpleJsonResponse> deleteAuthor (@RequestBody Author author) {
        if (author.getId() == null) {
            SimpleJsonResponse noIdResponse = new SimpleJsonResponse("Id must be provided", 200, true);

            return new ResponseEntity<>(noIdResponse, new HttpHeaders(), HttpStatus.OK);
        }
        try {
            authorService.deleteAuthor(author.getId());
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Author deleted successfully", 200, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }
}
