package com.example.java_task_2.data;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private String title;
    private Author author;
    private int year;
    private boolean isPublished;
    private int price;

    public Book(String title, Author author, int year, boolean isPublished, int price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isPublished = isPublished;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
