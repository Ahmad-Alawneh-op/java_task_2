package com.example.java_task_2.dao;

import com.example.java_task_2.MongoDbTestConfiguration;
import com.example.java_task_2.data.Book;
import com.example.java_task_2.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// @TODO: None of my attempts to create a mock DB works, this file doesn't work
@DataMongoTest
@ContextConfiguration(classes= MongoDbTestConfiguration.class)
public class BookDAOImplTests {

    private final BookDAOImpl bookDAO = new BookDAOImpl();

    Book createMockBookInstance() {
        return new Book("mockTitle", null, 100, true, 100, 100);
    }

    @Test
    void findBook_whenBookExists_thenReturnBookInstance() {
        Book book = bookDAO.findBook("mockId");

        // @TODO: If there is enough time, override equals() in Book to make this more clean
        Book newMockInstance = createMockBookInstance();
        assertEquals(book.getTitle(), newMockInstance.getTitle());
        assertEquals(book.getQuantity(), newMockInstance.getQuantity());
        assertEquals(book.getPrice(), newMockInstance.getPrice());
    }

    @Test
    void findBook_whenBookDoesntExist_thenReturnNull() {
        BookRepository bookRepositorySpy = spy(BookRepository.class);
        when(bookRepositorySpy.findById("mockId")).thenReturn(Optional.empty());
        ReflectionTestUtils.setField(bookDAO, "bookRepo", bookRepositorySpy);

        Book book = bookDAO.findBook("mockId");

        assertNull(book);
    }
}
