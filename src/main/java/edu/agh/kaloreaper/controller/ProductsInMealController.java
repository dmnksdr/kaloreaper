package edu.agh.kaloreaper.controller;

import edu.agh.kaloreaper.meal.Meal;
import edu.agh.kaloreaper.meal.ProductsInMeal;
import edu.agh.kaloreaper.repository.MealRepository;
import edu.agh.kaloreaper.repository.ProductsInMealRepository;
import edu.agh.kaloreaper.product.Product;
import edu.agh.kaloreaper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
class ProductsInMealController {

    private static final String VIEWS_MEAL_CREATE_OR_UPDATE_FORM = "meals/addproduct";

    private final MealRepository meals;
    private final ProductRepository products;
    private final ProductsInMealRepository productsInMealRepository;

    @Autowired
    public ProductsInMealController(MealRepository meals, ProductRepository products, ProductsInMealRepository productsInMeal) {
        this.meals = meals;
        this.products = products;
        this.productsInMealRepository = productsInMeal;
    }



//    @GetMapping("/meals/{mealId}/addProduct")
//    public String initCreationForm(@PathVariable("mealId") int mealId, Map<String, Object> model) {
//        Product product = new Product();
//        model.put("product", product);
//        return VIEWS_MEAL_CREATE_OR_UPDATE_FORM;
//    }
//
//    @PostMapping("/meals/{mealId}/addProduct")
//    public String processCreationForm(Product product, BindingResult result, @PathVariable("mealId") int mealId) {
//        Meal m = meals.findById(mealId);
//        productsInMealRepository.save(new ProductsInMeal(m, product, 12.3f));
//
//        return "redirect:/meals";
//    }






    @GetMapping("/meals/{mealId}/findProduct")
    public String initFindForm(Map<String, Object> model) {
        model.put("product", new Product());
        return "meals/findProductsToAdd";
    }

    @GetMapping("/meals/{mealId}/foundProducts")
    public String processFindForm(Product product, BindingResult result, Map<String, Object> model, @PathVariable("mealId") int mealId) {

        // allow parameterless GET request for /product to return all records
        if (product.getName() == null) {
            product.setName(""); // empty string signifies broadest possible search
        }
        Collection<Product> results = this.products.findByName(product.getName());

        if (results.isEmpty()) {
            // no product found
            result.rejectValue("name", "notFound", "not found");
            return "meals/findProductsToAdd";
        } else {
            // multiple owners found
            model.put("selections", results);
            return "meals/productsToAddList";
        }
    }

    @GetMapping("/meals/{mealId}/foundProduct/{productId}")
    public String processQuantityForm(Model model, @PathVariable("mealId") int mealId, @PathVariable("productId") int productId) {
        System.out.println("--==" + mealId + " " + productId);
        ProductsInMeal productsInMeal = new ProductsInMeal();
        productsInMeal.setMeal(meals.findById(mealId));
        productsInMeal.setProduct(products.findById(productId));
        model.addAttribute("productsInMeal", productsInMeal);
        return "meals/enterQuantity";
    }


    @PostMapping("/meals/newProductInMeal/{mealId}/{productId}")
    public String addProductToMeal(@ModelAttribute ProductsInMeal productInMeal, @PathVariable("mealId") int mealId, @PathVariable("productId") int productId) {
        productInMeal.setMeal(meals.findById(mealId));
        productInMeal.setProduct(products.findById(productId));
        productsInMealRepository.save(productInMeal);
        return "redirect:/meals";
    }

}
