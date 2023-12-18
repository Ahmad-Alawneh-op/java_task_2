package com.example.java_task_2.data;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private ArrayList<Book> purchasedBooks;

    public Customer(String name, String email, ArrayList<Book> purchasedBooks) {
        this.name = name;
        this.email = email;
        this.purchasedBooks = purchasedBooks;
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

    public ArrayList<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(ArrayList<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }
}
