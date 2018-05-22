package edu.agh.kaloreaper.product;

import edu.agh.kaloreaper.meal.ProductsInMeal;
import edu.agh.kaloreaper.model.NamedEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product extends NamedEntity {

    @Column(name = "calories")
    private Float calories;

    @Column(name = "proteins")
    private Float proteins;

    @Column(name = "fats")
    private Float fats;

    @Column(name = "carbonhydrates")
    private Float carbonhydrates;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;







    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductsInMeal> meals = new HashSet<>();

    public Set<ProductsInMeal> getMeals() {
        return meals;
    }

    public void setMeals(Set<ProductsInMeal> productsInMeal) {
        this.meals = productsInMeal;
    }







    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Float getProteins() {
        return proteins;
    }

    public void setProteins(Float proteins) {
        this.proteins = proteins;
    }

    public Float getFats() {
        return fats;
    }

    public void setFats(Float fats) {
        this.fats = fats;
    }

    public Float getCarbonhydrates() {
        return carbonhydrates;
    }

    public void setCarbonhydrates(Float carbonhydrates) {
        this.carbonhydrates = carbonhydrates;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
