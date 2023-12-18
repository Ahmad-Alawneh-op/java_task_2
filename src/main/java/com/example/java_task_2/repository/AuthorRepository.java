package com.example.java_task_2.repository;

import com.example.java_task_2.data.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
