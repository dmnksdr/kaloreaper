package edu.agh.kaloreaper.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User extends NamedEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "calories_demand")
    private Integer caloriesDemand;

    @Column(name = "proteins_demand")
    private Integer proteinsDemand;

    @Column(name = "carbohydrates_demand")
    private Integer carbohydratesDemand;

    @Column(name = "fats_demnad")
    private Integer fatsDemnad;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCaloriesDemand() {
        return caloriesDemand;
    }

    public void setCaloriesDemand(Integer caloriesDemand) {
        this.caloriesDemand = caloriesDemand;
    }

    public Integer getProteinsDemand() {
        return proteinsDemand;
    }

    public void setProteinsDemand(Integer proteinsDemand) {
        this.proteinsDemand = proteinsDemand;
    }

    public Integer getCarbohydratesDemand() {
        return carbohydratesDemand;
    }

    public void setCarbohydratesDemand(Integer carbohydratesDemand) {
        this.carbohydratesDemand = carbohydratesDemand;
    }

    public Integer getFatsDemnad() {
        return fatsDemnad;
    }

    public void setFatsDemnad(Integer fatsDemnad) {
        this.fatsDemnad = fatsDemnad;
    }
}
