package com.example.java_task_2.dao;

import com.example.java_task_2.data.Book;
import com.example.java_task_2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {

    @Autowired
    BookRepository bookRepo;

    @Override
    public Book findBook(String title) {
        Optional<Book> value = bookRepo.findById(title);
        return value.orElse(null);
    }

    @Override
    public List<Book> findBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findBooksByAuthor(String authorEmail, boolean includeUnpublished) {
        return bookRepo.findBooksByAuthorEmail(authorEmail, includeUnpublished);
    }

    @Override
    public boolean createBook(Book book) {
        try {
            bookRepo.insert(book);
            return true;
        } catch (Exception exception) {
            System.out.println("Error creating book!: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            bookRepo.save(book);
            return true;
        } catch (Exception exception) {
            System.out.println("Error updating book!: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBook(String title) {
        try {
            bookRepo.deleteById(title);
            return true;
        } catch (Exception exception) {
            System.out.println("Error deleting book!: " + exception.getMessage());
            return false;
        }
    }
}
