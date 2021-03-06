package edu.agh.kaloreaper.repository;

import edu.agh.kaloreaper.product.Product;
import edu.agh.kaloreaper.product.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends Repository<Product, Integer> {

    @Query("SELECT DISTINCT product FROM Product product left join fetch product.category WHERE product.name LIKE :name%")
    @Transactional(readOnly = true)
    Collection<Product> findByName(@Param("name") String name);

    @Query("SELECT pcategory FROM ProductCategory pcategory ORDER BY pcategory.name")
    @Transactional(readOnly = true)
    List<ProductCategory> findProductCategories();

    @Query("SELECT product FROM Product product WHERE product.id =:id")
    @Transactional(readOnly = true)
    Product findById(@Param("id") Integer id);


    void save(Product product);

}
