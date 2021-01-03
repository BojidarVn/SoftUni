package springdataintroexercise.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdataintroexercise.demo.entities.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);

    @Query("SELECT b FROM Book AS b WHERE b.author.id = 4 ORDER BY b.releaseDate DESC, b.title")
    List<Book> getAllBooksFromGeorgePowell();
}
