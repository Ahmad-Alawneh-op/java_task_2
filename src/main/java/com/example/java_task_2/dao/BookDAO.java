package com.example.java_task_2.dao;

import com.example.java_task_2.data.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookDAO {
    Book findBook(String title);
    List<Book> findBooks();
    List<Book> findBooksByAuthor(String authorEmail, boolean includeUnpublished);
    boolean createBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(String title);
}
