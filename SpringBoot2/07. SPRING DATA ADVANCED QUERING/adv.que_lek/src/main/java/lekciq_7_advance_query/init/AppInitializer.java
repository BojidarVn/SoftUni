package lekciq_7_advance_query.init;

import lekciq_7_advance_query.Repository.IngredientRepository;
import lekciq_7_advance_query.Repository.LabelRepository;
import lekciq_7_advance_query.Repository.ShampooRepository;
import lekciq_7_advance_query.entity.Ingredient;
import lekciq_7_advance_query.entity.Shampoo;
import lekciq_7_advance_query.util.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class AppInitializer implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public AppInitializer(ShampooRepository shampooRepository, LabelRepository labelRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("-".repeat(150) + "\n");


//        // Fetch Shampoos by Size           EXERCISE 1
//         shampooRepository.findBySizeOrderById(MEDIUM)
//                 .forEach(PrintUtil::printShampoo);

//        System.out.println("-".repeat(150) + "\n");

//        // Fetch Shampoos by Size or label   EXERCISE 2
//        shampooRepository.findBySizeOrLabelOrderByPriceDesc(MEDIUM, labelRepository.findByTitle("Vital").get())
//                .forEach(PrintUtil::printShampoo);

        //     System.out.println("-".repeat(150) + "\n");

//        // Fetch Shampoos by Price greater then or equal             EXERCISE 3
//        shampooRepository.findByPriceGreaterThanEqual(7.1)
//                .forEach(PrintUtil::printShampoo);
//
//
//
//        //Fetch Shampoos by Price between min and max Price          EXERCISE 3 + more
//   shampooRepository.findByPriceBetween(5.32,7.1)
//                .forEach(PrintUtil::printShampoo);
//

        // 	Select Ingredients by Names                          EXERCISE 5
//    ingredientRepository.findByNameIn(Set.of("Lavender","Herbs"," Apple")).forEach(PrintUtil::printIngredients);

//         Count Shampoos by Price                             EXERCISE 6
//        double maxPrice = 8.5;
//        System.out.printf("Number of shampoos with price less then %5.2f is: %d", maxPrice, shampooRepository.countShampoosByPriceLessThan(maxPrice));
//        System.out.println();


//
        System.out.println("-".repeat(150) + "\n");
//
        // Fetch Shampoos by Ingredients in List                        EXERCISE 7 moje bi
        //      shampooRepository.findWithIngredientsIn(Set.of("Berry","Mineral-Collagen")).forEach(PrintUtil::printShampoo);

        //                                                         EXERCISE 8
        //  shampooRepository.findByCountOfIngredientsLowerThen(3).forEach(PrintUtil::printShampoo);

        //	Delete Ingredients by Name              EXERCISE 9           ne trugna taq zada4a
//        String nameToDelete = "Macadamia Oil";
//        Ingredient ingredientToDelete = ingredientRepository.findByName(nameToDelete).get();
//        List<Shampoo> shampoosByIngredient = shampooRepository.findByIngredient(ingredientToDelete);
//        shampoosByIngredient.forEach(PrintUtil::printShampoo);
//        shampoosByIngredient.forEach(shampoo -> shampoo.getIngredients().remove(ingredientToDelete));
//        System.out.printf("Number of deleted ingredients with name='%s' is: %d",
//                nameToDelete, ingredientRepository.deleteAllByName(nameToDelete));
//        System.out.println("-".repeat(180) + "\n");
//        shampooRepository.findAll().forEach(PrintUtil::printShampoo);




        // ZADA4ATA S UPDATE I TQ NE IZLIZA          EXERCISE 11

        // Increase price of ingredients in list by
//        ingredientRepository.findAll().forEach(PrintUtil::printIngredients);

//        System.out.println("-".repeat(150) + "\n");

//        System.out.printf("Number of ingredientsupdate: d%",
//        ingredientRepository.updatePriceOfIngredientsInListBy(Set.of("Lavender","Herbs"," Apple"),1.2));


        ingredientRepository.findAll().forEach(PrintUtil::printIngredients);
        System.out.println("-".repeat(80) + "\n");

        System.out.printf("Number of ingredients updated: %d\n\nAfter update:\n",
                ingredientRepository.updatePriceOfIngredientsInListBy(Set.of("Lavender", "Herbs", "Apple"), 1.2));

        ingredientRepository.findAll().forEach(PrintUtil::printIngredients);
        System.out.println("-".repeat(80) + "\n");



        System.out.println("-".repeat(150) + "\n");

    }
}
