package com.springintroexercise.springintroexercise.repositories;

import com.springintroexercise.springintroexercise.entities.Author;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRep extends JpaRepository<Author, Integer> {

    @Query("SELECT a from Author as a ORDER BY  a.books.size DESC ")
    List<Author> findAuthorsByCountOfBooks();


}
