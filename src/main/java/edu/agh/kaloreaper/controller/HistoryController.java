package edu.agh.kaloreaper.controller;

import edu.agh.kaloreaper.meal.Meal;
import edu.agh.kaloreaper.meal.Meals;
import edu.agh.kaloreaper.model.User;
import edu.agh.kaloreaper.product.Product;
import edu.agh.kaloreaper.repository.MealRepository;
import edu.agh.kaloreaper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.util.*;

@Controller
class HistoryController {

    @Autowired
    private MealRepository meals;

    @Autowired
    private UserRepository users;

//    @Autowired
//    public MealController(MealRepository mealRepository) {
//        this.meals = mealRepository;
//    }

    @ModelAttribute("all_products")
    public Collection<Product> populateProducts() {
        return this.meals.findProducts();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/history")
    public String showHistoryMealList(Map<String, Object> model) {
        Meal meal = new Meal();
        List<Meal> sortedList = new ArrayList<>();

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByName(userName);

        sortedList.addAll(this.meals.findByUser(user));
        Collections.sort(sortedList);
        model.put("meals", sortedList);
        model.put("meal", meal);
        return "history/history";
    }


}
