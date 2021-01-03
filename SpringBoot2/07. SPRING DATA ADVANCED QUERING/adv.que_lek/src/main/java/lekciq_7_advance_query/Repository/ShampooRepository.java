package lekciq_7_advance_query.Repository;

import lekciq_7_advance_query.entity.Ingredient;
import lekciq_7_advance_query.entity.Label;
import lekciq_7_advance_query.entity.Shampoo;
import lekciq_7_advance_query.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findBySizeOrderById(Size size);




    List<Shampoo> findBySizeOrLabel(Size medium, String s);

    List<Shampoo> findBySizeOrLabelOrderByPriceDesc(Size medium, Label s);

    List<Shampoo> findByPriceGreaterThanEqual(double minPrice);


    List<Shampoo> findByPriceBetween(double minPrice, double maxPrice);

    int countShampoosByPriceLessThan(double maxPrice);

    @Query("SELECT s FROM Shampoo s, IN(s.ingredients) i WHERE i = :ingredient")
    List<Shampoo> findByIngredient(Ingredient ingredient);


    // @Query("SELECT s FROM Shampoo AS s JOIN s.ingredients AS i WHERE i.name IN :ingredient_names")
    @Query("SELECT s FROM Shampoo AS s, IN(s.ingredients) AS i WHERE i.name IN :ingredient_names")
    List<Shampoo> findWithIngredientsIn(@Param("ingredient_names")Iterable<String> ingredient_names);

    @Query("SELECT s FROM Shampoo AS s WHERE s.ingredients.size < :count")
    List<Shampoo> findByCountOfIngredientsLowerThen(@Param("count") int maxCount);


}
