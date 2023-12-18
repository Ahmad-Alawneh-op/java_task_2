package com.example.java_task_2.data;

public class Book {
    private String title;
    private Author author;
    private int year;
    private boolean isPublished;

    public Book(String title, Author author, int year, boolean isPublished) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isPublished = isPublished;
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
}
