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
    public Author findAuthor(String email) {
        Optional<Author> value = authorRepo.findById(email);
        return value.orElse(null);
    }

    @Override
    public List<Author> findAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public boolean createAuthor(Author author) {
        try {
            authorRepo.insert(author);
            return true;
        } catch (Exception exception) {
            System.out.println("Error creating author!: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAuthor(Author author) {
        try {
            authorRepo.save(author);
            return true;
        } catch (Exception exception) {
            System.out.println("Error updating author!: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAuthor(String email) {
        try {
            authorRepo.deleteById(email);
            return true;
        } catch (Exception exception) {
            System.out.println("Error deleting author!: " + exception.getMessage());
            return false;
        }
    }
}
