package com.example.java_task_2.data;

import org.springframework.data.annotation.Id;

public class Author {

    @Id
    private String id;
    private String name;
    private String email;

    public Author(String name, String email) {
        this.id = "aaaa";
        this.name = name;
        this.email = email;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
