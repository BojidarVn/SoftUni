package com.softuni.springintroex.services;

import com.softuni.springintroex.services.models.BookInfo;

import java.io.IOException;

public interface BookService {
    void seedBooksInDB() throws IOException;

    void printAllBooksByAgeRestriction(String ageRes);

    void printAllBooksByEditionTypeAndCopies();

    void printAllBooksByPriceInBounds();

    void printAllBooksNotInYear(String year);

    void printAllBookTitleContainsGivenString(String str);

    void printAllBooksBeforeDate(String date);

    void printAllBooksWithAuthorLastNameStarting(String start);

    void printNumberBooksCountWithTitleLengthBiggerThen(int length);

    BookInfo findBookByTitle(String title);

    void printUpdatedCount(String date, int copies );
}
