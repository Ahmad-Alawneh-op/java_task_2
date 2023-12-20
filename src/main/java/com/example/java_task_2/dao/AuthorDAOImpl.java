package com.example.java_task_2.dao;

import com.example.java_task_2.data.Author;
import com.example.java_task_2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private AuthorRepository authorRepo;

    @Override
    public Author findAuthor(String id) {
        Optional<Author> value = authorRepo.findById(id);
        return value.orElse(null);
    }

    @Override
    public List<Author> findAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepo.insert(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepo.deleteById(id);
    }
}
