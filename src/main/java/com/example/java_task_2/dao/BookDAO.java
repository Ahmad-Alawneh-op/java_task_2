package com.example.java_task_2.dao;

import com.example.java_task_2.data.Book;

import java.util.ArrayList;

public interface BookDAO {
    Book getBook(String title);
    ArrayList<Book> getBooks();
    ArrayList<Book> getBooksByAuthor(String authorEmail, boolean includeUnpublished);
    boolean createBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(String book);
}
