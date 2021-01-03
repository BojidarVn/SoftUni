package softuni.cardelar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardelar.domain.entities.Sale;

@Repository
public interface SeleRepository extends JpaRepository<Sale, Long> {
}
