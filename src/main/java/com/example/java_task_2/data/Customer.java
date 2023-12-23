package com.example.java_task_2.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;

public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    @DocumentReference
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
