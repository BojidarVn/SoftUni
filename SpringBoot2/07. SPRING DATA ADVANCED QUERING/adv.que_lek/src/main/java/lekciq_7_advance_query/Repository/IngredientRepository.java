package lekciq_7_advance_query.Repository;

import lekciq_7_advance_query.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameIn(Iterable<String> names);

    @Transactional
    int deleteAllByName(String name);

    Optional <Ingredient> findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient AS i SET i.price =i.price * :percentage WHERE i.name IN :names")
    int updatePriceOfIngredientsInListBy(@Param("names") Iterable<String> names,
                                         @Param("percentage") double percentage);
}
