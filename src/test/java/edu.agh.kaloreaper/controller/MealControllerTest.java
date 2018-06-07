package edu.agh.kaloreaper.controller;

import edu.agh.kaloreaper.meal.Meal;
import edu.agh.kaloreaper.meal.ProductsInMeal;
import edu.agh.kaloreaper.model.User;
import edu.agh.kaloreaper.product.Product;
import edu.agh.kaloreaper.repository.MealRepository;
import edu.agh.kaloreaper.repository.UserRepository;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MealController.class)
public class MealControllerTest{
    private static final int TEST_ID = 1;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MealRepository meals;

    @MockBean
    private UserRepository users;

    private User user;
    private Meal meal;
    private Product product;
    private ProductsInMeal productsInMeal;
    private ProductsInMeal.ProductsInMealId productsInMealId;
    private Set<ProductsInMeal> productsInMealSet;
    Date date = new Date(System.currentTimeMillis());

    @Before
    public void setup(){
        user = new User();
        user.setId(TEST_ID);
        user.setCaloriesDemand(20);
        user.setCarbohydratesDemand(20);
        user.setFatsDemand(20);
        user.setProteinsDemand(20);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setName("Janek");
        user.setYearOfBirth(1990);

        product = new Product();
        product.setCalories(20f);
        product.setCarbonhydrates(20f);
        product.setFats(20f);
        product.setProteins(20f);
        product.setMeals(productsInMealSet);
        product.setId(TEST_ID);
//
//        productsInMealId = new ProductsInMeal.ProductsInMealId(1,1);
//        productsInMeal = new ProductsInMeal();
//        productsInMeal.setId(new ProductsInMeal.ProductsInMealId(20,20));
//        productsInMeal.setMeal(meal);
//        productsInMeal.setProduct(product);
//        productsInMeal.setQuantity(20f);
//
//        productsInMealSet = new HashSet<ProductsInMeal>();
//        productsInMealSet.add(productsInMeal);

        meal = new Meal();
        meal.setId(TEST_ID);
        meal.setDate(date);
        meal.setUser(user);
        meal.setName("obiad");
       // meal.setProducts(productsInMealSet);
    }

    @Test
    public void testInitCreationForm() throws Exception{
        mockMvc.perform(get("/meals/new"))
            .andExpect(status().isOk())
            //.andExpect(model().attributeExists("meal"))
            .andExpect(view().name("meals/createOrUpdateForm"));
    }

    @Test
    public void testProcessCreationFormSuccess() throws Exception{
        mockMvc.perform(post("meal/new").param("name", "obiad"))
            .andExpect(status().is3xxRedirection());
    }
}
