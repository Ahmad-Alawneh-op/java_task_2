package com.example.java_task_2.repository;

import com.example.java_task_2.data.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{ 'author': ?0, $or: [{ 'isPublished': true }, { isPublished: { $ne: ?1 } }] }")
    List<Book> findBooksByAuthorEmail(String authorEmail, boolean includeUnpublished);
}
