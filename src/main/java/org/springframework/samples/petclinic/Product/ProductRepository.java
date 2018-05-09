package org.springframework.samples.petclinic.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends Repository<Product, Integer> {

    @Query("SELECT pcategory FROM ProductCategory pcategory ORDER BY pcategory.name")
    @Transactional(readOnly = true)
    List<ProductCategory> findProductCategories();


    @Query("SELECT product FROM Product product WHERE product.id =:id")
    @Transactional(readOnly = true)
    Product findById(@Param("id") Integer id);


    void save(Product product);

}
