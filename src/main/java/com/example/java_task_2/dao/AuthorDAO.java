package com.example.java_task_2.dao;

import com.example.java_task_2.data.Author;

import java.util.ArrayList;

public interface AuthorDAO {
    Author getAuthor(String email);
    ArrayList<Author> getAuthors();
    boolean createAuthor(Author author);
    boolean updateAuthor(Author author);
    boolean deleteAuthor(String email);
}
