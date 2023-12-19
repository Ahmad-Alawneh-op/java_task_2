package com.example.java_task_2.controller;

import com.example.java_task_2.dao.AuthorDAO;
import com.example.java_task_2.data.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorDAO authorDAO;
    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorDAO.findAuthors();
    }
}
