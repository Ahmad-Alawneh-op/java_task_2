package com.example.java_task_2.service;

import com.example.java_task_2.dao.AuthorDAO;
import com.example.java_task_2.data.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDAO authorDAO;

    @Override
    public Author getAuthor(String id) {
        return authorDAO.findAuthor(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.findAuthors();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorDAO.createAuthor(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorDAO.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(String id) {
        authorDAO.deleteAuthor(id);
    }
}
