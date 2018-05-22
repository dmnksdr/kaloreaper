package edu.agh.kaloreaper.meal;

import org.springframework.data.repository.Repository;

public interface ProductsInMealRepository extends Repository<ProductsInMeal, Integer> {


    void save(ProductsInMeal productsInMeal);

}
