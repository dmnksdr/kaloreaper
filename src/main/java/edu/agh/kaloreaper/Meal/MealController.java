package edu.agh.kaloreaper.Meal;

import edu.agh.kaloreaper.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
class MealController {

    private static final String VIEWS_MEAL_CREATE_OR_UPDATE_FORM = "meals/createOrUpdateMealForm";
    private final MealRepository meals;

    @Autowired
    public MealController(MealRepository mealRepository) {
        this.meals = mealRepository;
    }

    @ModelAttribute("all_products")
    public Collection<Product> populateProducts() {
        return this.meals.findProducts();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/meal/new")
    public String initCreationForm(Map<String, Object> model) {
        Meal meal = new Meal();
        model.put("meal", meal);
        List<Product> productList = this.meals.findProducts();
        model.put("productList", productList);
        return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/meal/new")
    public String processCreationForm(@Valid Meal meal, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
        } else {
            this.meals.save(meal);
            return "redirect:/meals/" + meal.getId();
        }
    }


    @GetMapping("/meals.html")
    public String showMealList(Map<String, Object> model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet
        // objects so it is simpler for Object-Xml mapping
        Meals meals = new Meals();
        meals.getMealList().addAll(this.meals.findAll());
        model.put("meals", meals);
        return "meals/mealList";
    }

    @GetMapping({ "/meals.json", "/meals.xml" })
    public @ResponseBody Meals showResourcesMealList() {
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
