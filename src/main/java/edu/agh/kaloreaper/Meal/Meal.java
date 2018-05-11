package edu.agh.kaloreaper.Meal;

import edu.agh.kaloreaper.Product.Product;
import edu.agh.kaloreaper.model.NamedEntity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "meal")
public class Meal extends NamedEntity {

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "products_in_meal",
        joinColumns = @JoinColumn(name = "meal_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;


    public Set<Product> getProducts() {
        if (this.products == null) {
            this.products = new HashSet<>();
        }
        return this.products;
    }

    protected void setProducts(Set<Product> products) {
        this.products = products;
    }

//    @XmlElement
//    public List<Product> getProducts() {
//        List<Product> sortedSpecs = new ArrayList<>(getProducts());
//        PropertyComparator.sort(sortedSpecs,
//                new MutableSortDefinition("name", true, true));
//        return Collections.unmodifiableList(sortedSpecs);
//    }

    public int getNrOfProducts() {
        return getProducts().size();
    }

    public void addProducts(Product product) {
        getProducts().add(product);
    }

}
