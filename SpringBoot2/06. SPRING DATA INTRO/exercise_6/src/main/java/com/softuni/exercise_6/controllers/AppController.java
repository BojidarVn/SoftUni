package com.softuni.exercise_6.controllers;

import com.softuni.exercise_6.services.AuthorService;
import com.softuni.exercise_6.services.BookService;
import com.softuni.exercise_6.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller

public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


//    private final FileUtils fileUtils;
//    public AppController(FileUtils fileUtils) {
//        this.fileUtils = fileUtils;
//    }

    @Override
    public void run(String... args) throws Exception {
        // String[] fileController= this.fileUtils.readFileContent(GlobalConstants.CATEGORIES_FILE_PATH); // vtori na4in
        // String[] fileController= this.fileUtils.readFileContent(CATEGORIES_FILE_PATH);

        Scanner sc = new Scanner(System.in);

// seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();


        System.out.println("Hello enjoy your time!");
        System.out.println("You need to chose number for exercise between 1 and 4 (inclusive) every else will be exit");
        int exerciseNumber = Integer.parseInt(sc.nextLine());

        while (exerciseNumber == 1 || exerciseNumber == 2 || exerciseNumber == 3 || exerciseNumber == 4) {

            switch (exerciseNumber) {

                case 1:

                    this.bookService.getAllBooksAfter2000()
                            .forEach(book -> {
                                System.out.printf("%s%n", book.getTitle());
                            });

                    break;

                case 2:

                    this.authorService.getAllAuthorsWithAtLeastOneBookBefore1990()
                            .forEach(r -> {
                                System.out.printf("%s %s%n", r.getFirstName(), r.getLastName());
                            });

                    break;

                case 3:

                    this.authorService.findAllAuthorsByCountOfBooks()
                            .forEach(a -> {
                                System.out.printf("%s %s %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size());
                            });

                    break;

                case 4:

                    this.bookService.getAllBooksFromGeorgePowell()
                            .forEach(book -> {
                                System.out.printf("%s, %s, %d%n", book.getTitle(), book.getReleaseDate(), book.getCopies());
                            });

                    break;

            }

            System.out.println("Chose number between 1 and 4 (inclusive) or eny else for exit!");
            exerciseNumber = Integer.parseInt(sc.nextLine());


        }
        System.out.println("Thank you for your time. Good luck with exam!");

    }
}
