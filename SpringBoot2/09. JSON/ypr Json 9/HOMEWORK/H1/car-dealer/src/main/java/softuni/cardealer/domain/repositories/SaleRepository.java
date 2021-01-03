package softuni.cardealer.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domain.entities.Customer;
import softuni.cardealer.domain.entities.Sale;

import java.util.Set;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale as s WHERE s.customer.sales.size > 0")
    Set<Customer> getAllCustomerTotalSales();

    Set<Sale> findAllBy();
}
