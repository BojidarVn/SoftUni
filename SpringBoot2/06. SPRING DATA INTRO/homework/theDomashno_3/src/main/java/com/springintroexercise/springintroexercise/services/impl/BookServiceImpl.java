package com.springintroexercise.springintroexercise.services.impl;

import com.springintroexercise.springintroexercise.entities.*;
import com.springintroexercise.springintroexercise.repositories.BookRep;
import com.springintroexercise.springintroexercise.services.AuthorService;
import com.springintroexercise.springintroexercise.services.BookService;
import com.springintroexercise.springintroexercise.services.CategoryService;
import com.springintroexercise.springintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private static final String BOOK_PATH = "src/main/resources/files/books.txt";

    private final BookRep bookRep;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRep bookRep, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRep = bookRep;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedBook() throws IOException {
        if (this.bookRep.count() != 0) {
            return;
        }

        String[] books = this.fileUtil.fileContext(BOOK_PATH);

        Arrays.stream(books).forEach(r -> {
            String[] params = r.split("\\s+");
            Author author = this.getRandomAuthor();
            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], formatter);
            int copies = Integer.parseInt(params[2]);
            BigDecimal price = new BigDecimal(params[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            String title = getTitle(params);
            Set<Category> categories = getRandomCategories();
            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);
            this.bookRep.saveAndFlush(book);
        });


    }

    @Override
    public List<Book> getAllNamesOfBookAfter2000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000", formatter);

        return this.bookRep.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore1990() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("01/01/1990", formatter);

        return this.bookRep.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<Book> findBooksByAuthor() {
        return this.bookRep.findByFirstNameLastName();
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        Random random = new Random();
        int bound = random.nextInt(3) + 1;

        for (int i = 1; i <= bound; i++) {
            int id = random.nextInt(8) + 1;
            categories.add(this.categoryService.getCategoryById(id));
        }
        return categories;
    }

    private String getTitle(String[] params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 5; i < params.length; i++) {
            stringBuilder.append(params[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt(this.authorService.getAllAuthorCount()) + 1;

        return this.authorService.findAuthorById(randomId);

    }
}
/*
  for (String s : books) {
            String[] tokens = s.split("\\s+");
            Book book = new Book();
            book.setAuthor(randomAuthor());
            EditionType editionType = EditionType.values()[Integer.parseInt(tokens[0])];
            book.setEditionType(editionType);
            LocalDate releaseDate = LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);
            book.setCopies(Integer.parseInt(tokens[2]));
            BigDecimal price = new BigDecimal(tokens[3]);
            book.setPrice(price);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(tokens[4])];
            book.setAgeRestriction(ageRestriction);
            StringBuilder str = new StringBuilder();
            for (int i = 5; i <= tokens.length - 1; i++) {
                str.append(tokens[i]).append(" ");
            }
            book.setTitle(str.toString().trim());
            book.setCategories(randomCategories());
            this.bookRep.saveAndFlush(book);
        }
 */