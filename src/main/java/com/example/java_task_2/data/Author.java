package com.example.java_task_2.data;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Author {
    private String name;
    @Id
    private String email;
    private ArrayList<Book> authoredBooks;

    public Author(String name, String email, ArrayList<Book> authoredBooks) {
        this.name = name;
        this.email = email;
        this.authoredBooks = authoredBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Book> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setAuthoredBooks(ArrayList<Book> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }
}
