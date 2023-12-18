package com.example.java_task_2.dao;

import com.example.java_task_2.data.Author;
import com.example.java_task_2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component("AuthorDAO")
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private AuthorRepository authorRepo;

    @Override
    public Author getAuthor(String email) {
        Optional<Author> value = authorRepo.findById(email);
        return value.orElse(null);
    }

    @Override
    public ArrayList<Author> getAuthors() {
        return null;
    }

    @Override
    public boolean createAuthor(Author author) {
        return false;
    }

    @Override
    public boolean updateAuthor(Author author) {
        return false;
    }

    @Override
    public boolean deleteAuthor(String email) {
        return false;
    }
}
