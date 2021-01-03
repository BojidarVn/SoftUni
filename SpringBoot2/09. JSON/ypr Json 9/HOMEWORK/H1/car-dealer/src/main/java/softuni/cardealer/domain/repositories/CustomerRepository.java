package softuni.cardealer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domain.entities.Customer;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Set<Customer> getAllByOrderByBirthDateAscYoungDriverAsc();

    @Query("SELECT c FROM Customer as c WHERE c.sales.size > 0")
    Set<Customer> getAllCustomerTotalSales();

}
