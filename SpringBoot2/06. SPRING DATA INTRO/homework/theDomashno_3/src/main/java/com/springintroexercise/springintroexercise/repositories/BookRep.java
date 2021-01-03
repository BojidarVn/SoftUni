package com.springintroexercise.springintroexercise.repositories;

import com.springintroexercise.springintroexercise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRep extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);

    List<Book> findAllByReleaseDateBefore(LocalDate localDate);


    @Query("SELECT b from Book as b WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "ORDER BY b.releaseDate DESC, b.title")
    List<Book> findByFirstNameLastName();
}
