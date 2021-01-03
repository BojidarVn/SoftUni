package com.softuni.springintroex.domain.repositories;

import com.softuni.springintroex.domain.entities.AgeRestriction;
import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.domain.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    // vse edno select b from book as b where ageRestriction = :ageRestriction
    Set<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);


    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    //   @Query("SELECT b FROM Book AS b WHERE b.price NOT BETWEEN 5 AND 40")    - kogato napi6em anytaciqta @Queri metoda otdolo e samo ime
    Set<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lessPrice, BigDecimal greaterPrice);

    @Query("SELECT b FROM Book AS b WHERE substring(b.releaseDate,0,4) NOT LIKE :year")
    Set<Book> findAllByReleaseDateNotInYear(String year);

    Set<Book> findAllByReleaseDateIsLessThan(LocalDate date);


    // select b from Book b JOIN author.id => where author.last starting with
    Set<Book> findAllByAuthorLastNameStartingWith(String start);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) >:length ")
    int getNumberOfBooksWithTitleLength(int length);

// select a.firstName, a.lastName,count(a.books)
// FROM author a

    Set<Book> findAllByTitleContaining(String str);


    Book findByTitle(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.copies= b.copies + :copies WHERE b.releaseDate > :date")
    int updateCopies(int copies, LocalDate date);


}
