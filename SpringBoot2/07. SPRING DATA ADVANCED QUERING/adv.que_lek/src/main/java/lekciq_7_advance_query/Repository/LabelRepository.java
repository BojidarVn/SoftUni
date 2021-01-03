package lekciq_7_advance_query.Repository;

import lekciq_7_advance_query.entity.Label;
import lekciq_7_advance_query.entity.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    Optional<Label> findByTitle(String title);
}
