package com.softuni.springintroex;

import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import com.softuni.springintroex.services.models.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Engine implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;


    @Autowired
    public Engine(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("-".repeat(100));
        System.out.println("Please insert a number from 1 to 11 to run exercise or type End to terminate the program");
        System.out.println("-".repeat(100));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String command = bf.readLine();

        while (!command.equals("End")) {

            try {
                int number = Integer.parseInt(command);
                switch (number) {
                    case 1:
                        System.out.println("Chose one option of: minor, teen or adult");
                        this.bookService.printAllBooksByAgeRestriction(bf.readLine());
                        break;
                    case 2:
                        this.bookService.printAllBooksByEditionTypeAndCopies();
                        break;
                    case 3:
                        this.bookService.printAllBooksByPriceInBounds();
                        break;
                    case 4:
                        System.out.println("You have to put one year between 1987 and 2015");
                        this.bookService.printAllBooksNotInYear(bf.readLine());
                        break;
                    case 5:
                        System.out.println("You have to chose a date if format dd-MM-yyyy");
                        this.bookService.printAllBooksBeforeDate(bf.readLine());
                        break;
                    case 6:
                        System.out.println("You have to chose a author ending string");
                        this.authorService.printAllAuthorsWithEndingsString(bf.readLine());
                        break;
                    case 7:
                        System.out.println("You have to chose  string  which contain in titles");
                        this.bookService.printAllBookTitleContainsGivenString(bf.readLine());
                        break;
                    case 8:
                        System.out.println("You have to write string. It will representing author last name");
                        this.bookService.printAllBooksWithAuthorLastNameStarting(bf.readLine());
                        break;
                    case 9:
                        System.out.println("You have to put some number INT");
                        this.bookService.printNumberBooksCountWithTitleLengthBiggerThen(Integer.parseInt(bf.readLine()));
                        System.out.println("Look careful you can miss the answer!");
                        break;
                    case 10:
                        this.authorService.printAllAuthorByBookCopies();
                        break;
                    case 11:
                        System.out.println("You have to put title from book collection for example you can use 'Things Fall Apart' " );
                        BookInfo bookByTitle = this.bookService.findBookByTitle(bf.readLine());
                        System.out.println(bookByTitle.getTitle()+ " " + bookByTitle.getEditionType() + " " + bookByTitle.getAgeRestriction());
                        break;

                    default:
                        System.out.println("Invalid exercise format");
                }

            } catch (Exception e) {
                System.out.println("Invalid input format");
            }

            System.out.println("-".repeat(100));
            System.out.println("Please insert a number from 1 to 11 to run exercise or type End to terminate the program");
            System.out.println("-".repeat(100));
            command = bf.readLine();
        }
        System.out.println("Thank you! GoodBye!");
        System.out.println("I wish you good luck with THE exam!");

//Ex 1
//        this.bookService.printAllBooksByAgeRestriction(bf.readLine());
//Ex 2
//        this.bookService.printAllBooksByEditionTypeAndCopies();
//Ex 3
//        this.bookService.printAllBooksByPriceInBounds();
//Ex 4
//        this.bookService.printAllBooksNotInYear(bf.readLine());
//Ex 5
//        this.bookService.printAllBooksBeforeDate(bf.readLine());
//Ex 6
//        this.authorService.printAllAuthorsWithEndingsString(bf.readLine());
//Ex 7
//        this.bookService.printAllBookTitleContainsGivenString(bf.readLine());

//Ex 8
//        this.bookService.printAllBooksWithAuthorLastNameStarting(bf.readLine());
//Ex 9
//        this.bookService.printNumberBooksCountWithTitleLengthBiggerThen(Integer.parseInt(bf.readLine()));
//Ex 10
//        this.authorService.printAllAuthorByBookCopies();
//Ex 11   da se poopravi printiraneto
//        BookInfo bookByTitle = this.bookService.findBookByTitle(bf.readLine());
//        System.out.println(bookByTitle.getTitle());
//        System.out.println(bookByTitle.getPrice());
//        System.out.println(bookByTitle.getCopies());
//Ex 12*
//    this.bookService.printUpdatedCount(bf.readLine(), Integer.parseInt(bf.readLine()));

    }

    void seedData() throws IOException {
        this.categoryService.seedCategoriesInDB();
        this.authorService.seedAuthorsInDB();
        this.bookService.seedBooksInDB();
    }

}
