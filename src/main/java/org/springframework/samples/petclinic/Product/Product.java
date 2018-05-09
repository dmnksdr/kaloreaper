package org.springframework.samples.petclinic.Product;

import org.springframework.samples.petclinic.model.NamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "product")
public class Product extends NamedEntity {

//    @Id
//    @GeneratedValue
//    private Integer id;

//    @Column(name = "name")
//    @NotEmpty
//    public String name;

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
