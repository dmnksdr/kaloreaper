package edu.agh.kaloreaper.meal;


import edu.agh.kaloreaper.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "products_in_meal")
public class ProductsInMeal {

    @EmbeddedId
    private ProductsInMealId id;

    @ManyToOne
    @JoinColumn(name = "fk_meal", insertable = false, updatable = false)
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "fk_product", insertable = false, updatable = false)
    private Product product;

    @Column(name = "quantity")
    private Float quantity;





    public ProductsInMeal() {}

    // czy to jest potrzebne?
    public ProductsInMeal(Meal meal, Product product, Float quantity) {

        this.id = new ProductsInMealId(meal.getId(), product.getId());

        this.meal = meal;
        this.product = product;
        this.quantity = quantity;

        meal.getProducts().add(this);
        product.getMeals().add(this);
    }


    public ProductsInMealId getId() {
        return id;
    }

    public void setId(ProductsInMealId id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }











    @Embeddable
    public static class ProductsInMealId implements Serializable {

        @Column(name = "fk_meal")
        protected Integer mealId;

        @Column(name = "fk_product")
        protected Integer productId;

        public ProductsInMealId() {

        }

        public ProductsInMealId(Integer mealId, Integer productId) {
            this.mealId = mealId;
            this.productId = productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductsInMealId that = (ProductsInMealId) o;
            return Objects.equals(mealId, that.mealId) &&
                Objects.equals(productId, that.productId);
        }

        @Override
        public int hashCode() {

            return Objects.hash(mealId, productId);
        }
    }

}
