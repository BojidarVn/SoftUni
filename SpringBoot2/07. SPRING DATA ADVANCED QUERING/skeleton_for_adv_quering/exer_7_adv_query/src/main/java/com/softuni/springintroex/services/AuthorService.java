package com.softuni.springintroex.services;

import com.softuni.springintroex.services.models.BookInfo;

import java.io.IOException;

public interface AuthorService {

    void seedAuthorsInDB() throws IOException;

    void printAllAuthorsWithEndingsString(String string);

    void printAllAuthorByBookCopies();


}
