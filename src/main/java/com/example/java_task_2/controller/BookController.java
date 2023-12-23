package com.example.java_task_2.controller;

import com.example.java_task_2.data.Book;
import com.example.java_task_2.data.SimpleJsonResponse;
import com.example.java_task_2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/byId")
    public Book getBookById(@RequestParam(defaultValue = "") String id) {
        return bookService.getBook(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/byAuthor")
    public List<Book> getAllBooks(@RequestParam(defaultValue = "") String authorId, @RequestParam(defaultValue = "false") boolean includeUnpublished) {
        return bookService.getBooksByAuthor(authorId, includeUnpublished);
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleJsonResponse> createBook (@RequestBody Book book) {
        try {
            book.setId(UUID.randomUUID().toString());
            bookService.addBook(book);
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Book created successfully: " + book.getId(), 201, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<SimpleJsonResponse> updateBook (@RequestBody Book book) {
        if (book.getId() == null) {
            SimpleJsonResponse noIdResponse = new SimpleJsonResponse("Id must be provided", 200, true);

            return new ResponseEntity<>(noIdResponse, new HttpHeaders(), HttpStatus.OK);
        }
        try {
            bookService.updateBook(book);
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Book updated successfully", 200, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SimpleJsonResponse> deleteBook (@RequestBody Book book) {
        if (book.getId() == null) {
            SimpleJsonResponse noIdResponse = new SimpleJsonResponse("Id must be provided", 200, true);

            return new ResponseEntity<>(noIdResponse, new HttpHeaders(), HttpStatus.OK);
        }
        try {
            bookService.deleteBook(book.getId());
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Book deleted successfully", 200, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }
}
