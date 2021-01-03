package com.softuni.exercise_6.services;

import com.softuni.exercise_6.entities.Author;
import com.softuni.exercise_6.entities.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author findAuthorById(Long id);

    List<Author> findAllAuthorsByCountOfBooks();

    List<Author> getAllAuthorsWithAtLeastOneBookBefore1990();


}
