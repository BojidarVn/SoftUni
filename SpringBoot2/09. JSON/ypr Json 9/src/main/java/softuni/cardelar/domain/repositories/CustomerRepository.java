package softuni.cardelar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardelar.domain.entities.Customer;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {



    Set<Customer> getAllByOrderByBirthDateAscYoungDriverAsc();
}
