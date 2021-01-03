package com.softuni.exercise_6.repositories;

import com.softuni.exercise_6.entities.Author;
import com.softuni.exercise_6.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

   List<Book> findAllByReleaseDateAfter(LocalDate localDate);

   @Query("SELECT b FROM Book AS b JOIN b.author AS a WHERE a.id=4 ORDER BY b.releaseDate DESC, b.title ASC")
   List<Book> findBooksWithAuthor();

}
