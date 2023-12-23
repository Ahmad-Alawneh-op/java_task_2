package com.example.java_task_2.service;

import com.example.java_task_2.data.Book;

import java.util.List;

public interface BookService {
    Book getBook(String id);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(String authorId, boolean includeUnpublished);
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteBook(String id);
}
