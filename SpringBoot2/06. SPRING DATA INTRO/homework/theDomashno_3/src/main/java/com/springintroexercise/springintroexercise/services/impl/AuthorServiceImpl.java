package com.springintroexercise.springintroexercise.services.impl;

import com.springintroexercise.springintroexercise.entities.Author;
import com.springintroexercise.springintroexercise.repositories.AuthorRep;
import com.springintroexercise.springintroexercise.services.AuthorService;
import com.springintroexercise.springintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final static String AUTHOR_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRep authorRep;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRep authorRep, FileUtil fileUtil) {
        this.authorRep = authorRep;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRep.count() != 0) {
            return;
        }

        String[] authors = this.fileUtil.fileContext(AUTHOR_PATH);

        for (String s : authors) {
            String[] tokens = s.split("\\s+");

            Author author = new Author();
            author.setFirstName(tokens[0]);
            author.setLastName(tokens[1]);

            this.authorRep.saveAndFlush(author);
        }
    }

    @Override
    public int getAllAuthorCount() {
        return (int) this.authorRep.count();
    }

    @Override
    public Author findAuthorById(Integer id) {
        return this.authorRep.getOne(id);
    }

    @Override
    public List<Author> getAllAuthorsByCountOfBooks() {
        return this.authorRep.findAuthorsByCountOfBooks();
    }


}
