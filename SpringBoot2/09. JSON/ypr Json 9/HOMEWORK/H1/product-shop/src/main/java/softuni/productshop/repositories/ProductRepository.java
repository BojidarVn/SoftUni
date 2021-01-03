package softuni.productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.productshop.domain.entities.Product;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findAllByPriceBetweenOrderByPriceAsc(double lowerBound, double higherBound);

    Set<Product> findAllBySellerIdIsNotNull();

    @Query("SELECT p FROM Product as p WHERE p.sellerId.users.size > 0")
    Set<Product> getAllUsersAndProducts();
}
