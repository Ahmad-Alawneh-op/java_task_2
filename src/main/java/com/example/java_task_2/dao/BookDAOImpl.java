package com.example.java_task_2.dao;

import com.example.java_task_2.data.Book;
import com.example.java_task_2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAOImpl implements BookDAO {
    @Autowired
    BookRepository bookRepo;

    @Override
    public Book findBook(String id) {
        Optional<Book> value = bookRepo.findById(id);
        return value.orElse(null);
    }

    @Override
    public List<Book> findBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findBooksByAuthor(String authorId, boolean includeUnpublished) {
        return bookRepo.findBooksByAuthorId(authorId, includeUnpublished);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepo.insert(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }
}
