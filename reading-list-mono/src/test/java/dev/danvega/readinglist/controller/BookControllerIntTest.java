package dev.danvega.readinglist.controller;

import dev.danvega.readinglist.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerIntTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void findAllBooksReturnsAllBooks() {
        ResponseEntity<List<Book>> books = restTemplate.exchange("/api/books",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {});

        assertEquals(HttpStatus.OK,books.getStatusCode());
        assertEquals(3,books.getBody().size());
    }

}