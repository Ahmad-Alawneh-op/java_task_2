package com.example.java_task_2.service;

import com.example.java_task_2.data.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthor(String id);
    Author getAuthorByName(String name);
    List<Author> getAllAuthors();
    Author addAuthor(Author author);
    Author updateAuthor(Author author);
    void deleteAuthor(String id);
}
