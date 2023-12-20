package com.example.java_task_2.dao;

import com.example.java_task_2.data.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookDAO {
    Book findBook(String id);
    List<Book> findBooks();
    List<Book> findBooksByAuthor(String authorId, boolean includeUnpublished);
    Book createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(String id);
}
