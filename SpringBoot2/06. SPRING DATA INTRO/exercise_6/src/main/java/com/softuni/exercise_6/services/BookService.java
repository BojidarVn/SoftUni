package com.softuni.exercise_6.services;

import com.softuni.exercise_6.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksAfter2000();

 List<Book> getAllBooksFromGeorgePowell();
}
