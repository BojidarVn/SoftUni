package springdataintroexercise.demo.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintroexercise.demo.constraints.GlobalConstraints;
import springdataintroexercise.demo.entities.Author;
import springdataintroexercise.demo.repositories.AuthorRepository;
import springdataintroexercise.demo.services.AuthorService;
import springdataintroexercise.demo.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0){
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(GlobalConstraints.AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
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
    public List<Author> FindAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public List<Author> allAuthorsWithAtLeastOneBookBefore1990() {


        return this.authorRepository.findAllByBooksGreaterThanAndBooksBefore1990();
    }
}
