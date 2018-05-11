package edu.agh.kaloreaper.Meal;

import edu.agh.kaloreaper.Product.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


public interface MealRepository extends Repository<Meal, Integer> {

//    @Query("SELECT DISTINCT meal FROM Meal meal left join fetch meal.products left join fetch  WHERE product.name LIKE :name%")
//    @Transactional(readOnly = true)
//    Collection<Meal> findByName(@Param("name") String name);

    @Query("SELECT product FROM Product product ORDER BY product.name")
    @Transactional(readOnly = true)
    List<Product> findProducts();


    @Query("SELECT meal FROM Meal meal WHERE meal.id =:id")
    @Transactional(readOnly = true)
    Meal findById(@Param("id") Integer id);

    void save(Meal meal);


    @Transactional(readOnly = true)
    @Cacheable("meal")
    Collection<Meal> findAll() throws DataAccessException;

}
