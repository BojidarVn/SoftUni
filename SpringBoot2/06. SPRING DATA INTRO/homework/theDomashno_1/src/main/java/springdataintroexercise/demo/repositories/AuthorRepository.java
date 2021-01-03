package springdataintroexercise.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdataintroexercise.demo.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAuthorByCountOfBook();

    @Query("SELECT DISTINCT a FROM Author a inner join Book as b on b.author.id = a.id WHERE b.author.books.size > 0 AND " +
            "substring(b.releaseDate, 0, 4) < '1990' ")
    List<Author> findAllByBooksGreaterThanAndBooksBefore1990();

}
