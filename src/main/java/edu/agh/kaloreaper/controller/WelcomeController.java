package edu.agh.kaloreaper.controller;

import edu.agh.kaloreaper.meal.Meal;
import edu.agh.kaloreaper.meal.ProductsInMeal;
import edu.agh.kaloreaper.product.Product;
import edu.agh.kaloreaper.repository.MealRepository;
import edu.agh.kaloreaper.repository.UserRepository;
import edu.agh.kaloreaper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.Collection;

@Controller
class WelcomeController {

    @Autowired
    UserRepository users;

    @Autowired
    MealRepository meals;

    @GetMapping("/home")
    public String welcome(Model model) {
        Date currentDate = new Date(System.currentTimeMillis());
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User activeUser = users.findByName(userName);
        Collection<Meal> todayMeals = meals.findByDateAndUser(currentDate, activeUser);
        UserDemand userDemand = new UserDemand(activeUser);
        for (Meal meal : todayMeals) {
            for (ProductsInMeal productInMeal : meal.getProducts()) {
                Product product = productInMeal.getProduct();
                Double quantity = new Double(productInMeal.getQuantity());
                userDemand.addCalories(product.getCalories() * quantity / 100);
                userDemand.addProteins(product.getProteins() * quantity / 100);
                userDemand.addCarbonhydrates(product.getCarbonhydrates() * quantity / 100);
                userDemand.addFats(product.getFats() * quantity / 100);
            }
        }
        userDemand.calculatePercentage();
        model.addAttribute("demand", userDemand);

        return "home";
    }

}


class UserDemand {

    User user;

    private Double calories = 0.0;
    private Double proteins = 0.0;
    private Double carbonhydrates = 0.0;
    private Double fats = 0.0;

    private int caloriesPercent = 0;
    private int proteinsPercent = 0;
    private int carbonhydratesPercent = 0;
    private int fatsPercent = 0;

    public UserDemand(User user) {
        this.user = user;
    }

    public void calculatePercentage() {
        caloriesPercent = (int) (100 * calories / user.getCaloriesDemand());
        proteinsPercent = (int) (100 * proteins / user.getProteinsDemand());
        carbonhydratesPercent = (int) (100 * carbonhydrates / user.getCarbohydratesDemand());
        fatsPercent = (int) (100 * fats / user.getFatsDemand());
    }


    public String getCalories() {
        return String.format("%.1f", calories);
    }

    public void addCalories(Double calories) {
        this.calories += calories;
    }

    public String getProteins() {
        return String.format("%.1f", proteins);
    }

    public void addProteins(Double proteins) {
        this.proteins += proteins;
    }

    public String getCarbonhydrates() {
        return String.format("%.1f", carbonhydrates);
    }

    public void addCarbonhydrates(Double carbonhydrates) {
        this.carbonhydrates += carbonhydrates;
    }

    public String getFats() {
        return String.format("%.1f", fats);
    }

    public void addFats(Double fats) {
        this.fats += fats;
    }


    public int getCaloriesPercent() {
        return caloriesPercent;
    }

    public int getProteinsPercent() {
        return proteinsPercent;
    }

    public int getCarbonhydratesPercent() {
        return carbonhydratesPercent;
    }

    public int getFatsPercent() {
        return fatsPercent;
    }
}
