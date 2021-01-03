package softuni.cardelar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.cardelar.domain.entities.Part;

public interface PartRepository  extends JpaRepository<Part, Long> {


}
