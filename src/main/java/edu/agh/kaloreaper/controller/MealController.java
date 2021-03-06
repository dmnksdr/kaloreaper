package edu.agh.kaloreaper.controller;

import edu.agh.kaloreaper.meal.Meal;
import edu.agh.kaloreaper.meal.Meals;
import edu.agh.kaloreaper.model.User;
import edu.agh.kaloreaper.repository.MealRepository;
import edu.agh.kaloreaper.product.Product;
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
import java.time.LocalDate;
import java.util.*;

@Controller
class MealController {

    private static final String VIEWS_MEAL_CREATE_OR_UPDATE_FORM = "meals/createOrUpdateMealForm";

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

//    @GetMapping("/meal/new")
//    public String initCreationForm(Map<String, Object> model) {
//        Meal meal = new Meal();
//        model.put("meal", meal);
//        List<Product> productList = this.meals.findProducts();
//        model.put("productList", productList);
//        return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
//    }

    @PostMapping("/meal/new")
    public String processCreationForm(@Valid Meal meal, BindingResult result) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByName(userName);
        meal.setDate(new Date(System.currentTimeMillis()));
        meal.setUser(user);
        if (result.hasErrors()) {
            return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
        } else {
            this.meals.save(meal);
            return "redirect:/meals";
        }
    }



//    @PostMapping("/meal/ajax_new")
//    public String processAjaxCreationForm(Model model, @ModelAttribute(value="meal") @Valid Meal meal, BindingResult result) {
//        if (result.hasErrors()) {
//            return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
//        } else {
//            this.meals.save(meal);
//            return "redirect:/meals/" + meal.getId();
//        }
//    }


    @GetMapping("/meals")
    public String showMealList(Map<String, Object> model) {
        Meal meal = new Meal();
//        Meals meals = new Meals();
//        meals.getMealList().addAll(this.meals.findAll());
        List<Meal> sortedList = new ArrayList<>();
//        sortedList.addAll(this.meals.findAll());

        Date date = new Date(System.currentTimeMillis());
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByName(userName);


        sortedList.addAll(this.meals.findByDateAndUser(date, user));

        Collections.sort(sortedList);
        model.put("meals", sortedList);
        model.put("meal", meal);
        return "meals/mealList";
    }


    @GetMapping({ "/meals.json", "/meals.xml" })
    public @ResponseBody
    Meals showResourcesMealList() {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet
        // objects so it is simpler for JSon/Object mapping
        Meals meals = new Meals();
        meals.getMealList().addAll(this.meals.findAll());
        return meals;
    }

    @GetMapping("/meals/{mealId}")
    public ModelAndView showProduct(@PathVariable("mealId") int mealId) {
        ModelAndView mav = new ModelAndView("meals/mealDetails");
        mav.addObject("meal", this.meals.findById(mealId));
        return mav;
    }

}
