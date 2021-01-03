package com.springintroexercise.springintroexercise.services;

import com.springintroexercise.springintroexercise.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    int getAllAuthorCount();

    Author findAuthorById(Integer id);

    List<Author> getAllAuthorsByCountOfBooks();
}
