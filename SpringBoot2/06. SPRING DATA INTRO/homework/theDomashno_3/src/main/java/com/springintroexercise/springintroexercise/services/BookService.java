package com.springintroexercise.springintroexercise.services;

import com.springintroexercise.springintroexercise.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBook() throws IOException;

    List<Book> getAllNamesOfBookAfter2000();

    List<Book> findAllByReleaseDateBefore1990();

    List<Book> findBooksByAuthor();

}

