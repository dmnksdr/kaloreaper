package edu.agh.kaloreaper.meal;

import edu.agh.kaloreaper.model.NamedEntity;
import edu.agh.kaloreaper.model.User;
import edu.agh.kaloreaper.product.ProductCategory;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;


@Entity
@Table(name = "meal")
public class Meal extends NamedEntity implements Comparable<Meal> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date")
    private java.sql.Date date;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public int compareTo(Meal o) {
        Integer thisId = this.getId();
        Integer oId = o.getId();
        return thisId.compareTo(oId);
    }
}
