package softuni.cardelar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardelar.domain.entities.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
