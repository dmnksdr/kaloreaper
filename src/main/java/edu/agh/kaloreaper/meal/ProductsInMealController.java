package edu.agh.kaloreaper.meal;

import edu.agh.kaloreaper.product.Product;
import edu.agh.kaloreaper.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
class ProductsInMealController {

    private static final String VIEWS_MEAL_CREATE_OR_UPDATE_FORM = "meals/addproduct";

    private final MealRepository meals;
    private final ProductRepository products;
    private final ProductsInMealRepository productsInMeal;

    @Autowired
    public ProductsInMealController(MealRepository meals, ProductRepository products, ProductsInMealRepository productsInMeal) {
        this.meals = meals;
        this.products = products;
        this.productsInMeal = productsInMeal;
    }



    @GetMapping("/meals/{mealId}/addProduct")
    public String initCreationForm(@PathVariable("mealId") int mealId, Map<String, Object> model) {
        Product product = new Product();
        model.put("product", product);
        return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/meals/{mealId}/addProduct")
    public String processCreationForm(Product product, BindingResult result, @PathVariable("mealId") int mealId) {
        Meal m = meals.findById(mealId);
        productsInMeal.save(new ProductsInMeal(m, product, 12.3f));

        return "redirect:/meal/{mealId}/addProduct";


    }

}
