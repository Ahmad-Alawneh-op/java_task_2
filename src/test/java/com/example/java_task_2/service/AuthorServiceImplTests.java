package com.example.java_task_2.service;

import com.example.java_task_2.dao.AuthorDAO;
import com.example.java_task_2.data.Author;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorServiceImplTests {

    private final AuthorServiceImpl authorService = new AuthorServiceImpl();

    private final AuthorDAO authorDAOSpy = spy(AuthorDAO.class);
    public Author getMockAuthorInstance() {
        return new Author("mockName", "mockEmail");
    }

    @BeforeEach
    public void prepareMockDAO() {
        when(authorDAOSpy.findAuthor("mockId")).thenReturn(getMockAuthorInstance());
        when(authorDAOSpy.findAuthorByName("mockName")).thenReturn(getMockAuthorInstance());
        when(authorDAOSpy.findAuthors()).thenReturn(List.of(getMockAuthorInstance()));
        when(authorDAOSpy.createAuthor(getMockAuthorInstance())).thenReturn(getMockAuthorInstance());
        when(authorDAOSpy.updateAuthor(getMockAuthorInstance())).thenReturn(getMockAuthorInstance());
        ReflectionTestUtils.setField(authorService, "authorDAO", authorDAOSpy);
    }

    @Test
    public void getAuthor_whenIdIsProvided_thenReturnAuthor() {
        Author result = authorService.getAuthor("mockId");

        assertEquals(result, getMockAuthorInstance());
    }

    @Test
    public void getAuthorByName_whenNameIsProvided_thenReturnAuthor() {
        Author result = authorService.getAuthorByName("mockName");

        assertEquals(result, getMockAuthorInstance());
    }

    @Test
    public void getAllAuthors_returnAllAuthors() {
        List<Author> result = authorService.getAllAuthors();

        assertEquals(result.size(), 1);
        assertEquals(result.get(0), getMockAuthorInstance());
    }

    @Test
    public void updateAuthor_whenAuthorIsProvided_thenUpdateAndReturnAuthor() {
        Author result = authorService.updateAuthor(getMockAuthorInstance());

        assertEquals(result, getMockAuthorInstance());
    }

    @Test
    public void deleteAuthor_whenIdIsProvided_thenDeleteAuthor() {
        authorService.deleteAuthor("mockId");

        verify(authorDAOSpy, times(1)).deleteAuthor("mockId");
    }
}
