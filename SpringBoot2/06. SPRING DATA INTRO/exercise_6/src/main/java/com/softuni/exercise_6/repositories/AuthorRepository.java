package com.softuni.exercise_6.repositories;

import com.softuni.exercise_6.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAuthorByCountOfBook();


    @Query("SELECT DISTINCT a FROM Author AS a JOIN a.books AS b WHERE b.releaseDate<'1990-01-01'")
    List<Author> bookBefore1990();


}
