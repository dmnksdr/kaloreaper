package edu.agh.kaloreaper.meal;

import edu.agh.kaloreaper.model.NamedEntity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "meal")
public class Meal extends NamedEntity implements Comparable<Meal>{

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


    @Override
    public int compareTo(Meal o) {
        Integer thisId = this.getId();
        Integer oId = o.getId();
        return thisId.compareTo(oId);
    }
}
