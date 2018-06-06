package edu.agh.kaloreaper.repository;

import edu.agh.kaloreaper.meal.ProductsInMeal;
import org.springframework.data.repository.Repository;

public interface ProductsInMealRepository extends Repository<ProductsInMeal, Integer> {


    void save(ProductsInMeal productsInMeal);

}
