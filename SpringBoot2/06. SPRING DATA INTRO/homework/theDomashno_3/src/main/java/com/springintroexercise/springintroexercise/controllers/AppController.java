package com.springintroexercise.springintroexercise.controllers;

import com.springintroexercise.springintroexercise.entities.Author;
import com.springintroexercise.springintroexercise.entities.Book;
import com.springintroexercise.springintroexercise.services.AuthorService;
import com.springintroexercise.springintroexercise.services.BookService;
import com.springintroexercise.springintroexercise.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    public AppController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategory();
        this.authorService.seedAuthors();
        this.bookService.seedBook();

        //  ex1();
        // ex2();
        // ex3();
        ex4();

    }

    private void ex4() {
        this.bookService.findBooksByAuthor()
                .stream()
                .forEach(b ->
                        System.out.printf("%s %s %d%n", b.getTitle()
                                , b.getReleaseDate(), b.getCopies()));
    }

    private void ex3() {
        this.authorService.getAllAuthorsByCountOfBooks()
                .stream()
                .forEach(a -> System.out.printf("%s %s %d%n",
                        a.getFirstName(),
                        a.getLastName(),
                        a.getBooks().size()));
    }

    private void ex2() {
        List<Book> books = this.bookService.findAllByReleaseDateBefore1990();

        for (Book book : books) {
            System.out.println(book.getAuthor().getFirstName());
            System.out.println(book.getAuthor().getLastName());
        }
    }

    private void ex1() {
        List<Book> books = this.bookService.getAllNamesOfBookAfter2000();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}
