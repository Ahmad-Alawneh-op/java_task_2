package com.example.java_task_2.repository;

import com.example.java_task_2.data.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    // THIS IS NOT ACCEPTING SEARCH BY AUTHOR NAME, WHY?
    @Query("{ 'author': ?0, $or: [{ 'isPublished': true }, { isPublished: { $ne: ?1 } }] }")
    List<Book> findBooksByAuthorId(String authorId, boolean includeUnpublished);
}
