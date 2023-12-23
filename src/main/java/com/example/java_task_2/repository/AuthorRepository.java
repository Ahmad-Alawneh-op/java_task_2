package com.example.java_task_2.repository;

import com.example.java_task_2.data.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {

    @Query("{ 'name': ?0 }")
    Optional<Author> findAuthorByName(String authorName);
}
