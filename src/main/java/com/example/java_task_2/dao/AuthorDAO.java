package com.example.java_task_2.dao;

import com.example.java_task_2.data.Author;

import java.util.List;

public interface AuthorDAO {
    Author findAuthor(String email);
    List<Author> findAuthors();
    boolean createAuthor(Author author);
    boolean updateAuthor(Author author);
    boolean deleteAuthor(String email);
}
