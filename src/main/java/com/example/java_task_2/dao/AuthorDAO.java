package com.example.java_task_2.dao;

import com.example.java_task_2.data.Author;

import java.util.List;

public interface AuthorDAO {
    Author findAuthor(String id);
    List<Author> findAuthors();
    Author createAuthor(Author author);
    Author updateAuthor(Author author);
    void deleteAuthor(String id);
}
