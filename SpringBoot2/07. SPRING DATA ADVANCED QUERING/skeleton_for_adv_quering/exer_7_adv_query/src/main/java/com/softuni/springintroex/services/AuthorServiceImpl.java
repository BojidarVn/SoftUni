package com.softuni.springintroex.services;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.domain.entities.Author;
import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.domain.repositories.AuthorRepository;
import com.softuni.springintroex.services.models.BookInfo;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthorsInDB() throws IOException {
        String[] lines = this.fileUtil.readFileContent(GlobalConstants.AUTHORS_FILE_PATH);

        for (String line : lines) {
            String[] tokens = line.split("\\s+");


            Author author = new Author(tokens[0], tokens[1]);

            this.authorRepository.saveAndFlush(author);
        }

    }

    @Override
    public void printAllAuthorsWithEndingsString(String string) {
        this.authorRepository.findAllByFirstNameEndingWith(string)
                .forEach(a-> System.out.printf("%s %s%n",a.getFirstName(),a.getLastName()));
    }

    @Override
    public void printAllAuthorByBookCopies() {
        List<Author> authors=this.authorRepository.findAll();

        Map<String ,Integer> authorsCopies=new HashMap<>();

        authors.forEach(author -> {
          int copies=  author
                  .getBooks()
                  .stream()
                  .mapToInt(Book::getCopies).sum();
          authorsCopies.put(author.getFirstName() + " " + author.getLastName(),copies);
        });

        authorsCopies
                .entrySet()
                .stream().sorted((current, next) -> Integer.compare(next.getValue(), current.getValue()))
                .forEach(author -> System.out.printf("%s %d%n",author.getKey(),author.getValue()));


    }




}
