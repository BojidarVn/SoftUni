package softuni.productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.productshop.domain.entities.Category;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category as c ORDER BY c.products.size DESC ")
    Set<Category> getAllCategoriesByProducts();
}
