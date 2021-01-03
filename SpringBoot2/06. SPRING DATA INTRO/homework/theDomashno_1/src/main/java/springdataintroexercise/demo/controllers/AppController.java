package springdataintroexercise.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataintroexercise.demo.entities.Book;
import springdataintroexercise.demo.services.AuthorService;
import springdataintroexercise.demo.services.BookService;
import springdataintroexercise.demo.services.CategoryService;

import java.util.List;
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

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("--------CHANGE THE USERNAME AND PASSWORD IN APPLICATION.PROPERTIES--------");

            System.out.println("Enter which exercise you want: 1, 2, 3, 4 or select 0 for the program to end.");
            int num = Integer.parseInt(scanner.nextLine());
            switch (num) {
                case 1:
                    List<Book> books = this.bookService.getAllBooksAfter2000();
                    for (Book book : books) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 2:
                    this.authorService
                            .allAuthorsWithAtLeastOneBookBefore1990()
                            .forEach(author -> {
                                System.out.printf("%s %s%n", author.getFirstName(), author.getLastName());
                            });
                    break;
                case 3:
                    this.authorService
                            .FindAllAuthorsByCountOfBooks()
                            .forEach(a -> {
                                System.out.printf("%s %s %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size());
                            });
                    break;
                case 4:
                    this.bookService.getAllBooksFromGeorgePowell()
                            .forEach(b -> {
                                System.out.printf("%s %s %d%n", b.getTitle(), b.getReleaseDate(), b.getCopies());
                            });
                    break;
                case 0:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid exercise!");
                    break;
            }
        }
    }
}
