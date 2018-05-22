package edu.agh.kaloreaper.meal;

import edu.agh.kaloreaper.model.NamedEntity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "meal")
public class Meal extends NamedEntity {

    @OneToMany(mappedBy = "meal")
    private Set<ProductsInMeal> products;

    public Set<ProductsInMeal> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductsInMeal> productsInMeal) {
        this.products = productsInMeal;
    }


    public int getNrOfProducts() {
        return getProducts().size();
    }
}
