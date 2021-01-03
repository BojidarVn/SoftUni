package com.softuni.exercise_6.services.impl;

import com.softuni.exercise_6.entities.Author;
import com.softuni.exercise_6.repositories.AuthorRepository;
import com.softuni.exercise_6.services.AuthorService;
import com.softuni.exercise_6.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.softuni.exercise_6.constants.GlobalConstants.AUTHOR_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtils fileUtils;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtils fileUtils) {
        this.authorRepository = authorRepository;
        this.fileUtils = fileUtils;
    }

    @Override
    public void seedAuthors() throws IOException {

        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] fillContent = this.fileUtils.readFileContent(AUTHOR_FILE_PATH);

        Arrays.stream(fillContent)
                .forEach(r -> {
                    String[] params = r.split("\\s+");
                    Author author = new Author(params[0], params[1]);

                    this.authorRepository.saveAndFlush(author);
                });
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {

        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public List<Author> getAllAuthorsWithAtLeastOneBookBefore1990() {

        return this.authorRepository.bookBefore1990();

    }
}
