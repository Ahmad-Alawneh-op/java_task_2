package com.example.java_task_2.service;

import com.example.java_task_2.dao.BookDAO;
import com.example.java_task_2.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;

    @Override
    public Book getBook(String id) {
        return bookDAO.findBook(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findBooks();
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName, boolean includeUnpublished) {
        return bookDAO.findBooksByAuthor(authorName, includeUnpublished);
    }

    @Override
    public Book addBook(Book book) {
        return bookDAO.createBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public void deleteBook(String id) {
        bookDAO.deleteBook(id);
    }
}
