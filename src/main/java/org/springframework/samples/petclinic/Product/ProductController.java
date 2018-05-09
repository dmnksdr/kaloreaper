package org.springframework.samples.petclinic.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
class ProductController {

    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
    private final ProductRepository products;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.products = productRepository;
    }

    @ModelAttribute("categories")
    public Collection<ProductCategory> populateProductCategories() {
        return this.products.findProductCategories();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/products/new")
    public String initCreationForm(Map<String, Object> model) {
        Product product = new Product();
        model.put("product", product);
        return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/products/new")
    public String processCreationForm(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        } else {
            this.products.save(product);
            return "redirect:/products/" + product.getId();
        }
    }


    @GetMapping("/products/{productId}/edit")
    public String initUpdateProductForm(@PathVariable("productId") int productId, Model model) {
        Product product = this.products.findById(productId);
        model.addAttribute(product);
        return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/products/{productId}/edit")
    public String processUpdateProductForm(@Valid Product product, BindingResult result, @PathVariable("productId") int productId) {
        if (result.hasErrors()) {
            return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
        } else {
            product.setId(productId);
            this.products.save(product);
            return "redirect:/products/{productId}";
        }
    }


    @GetMapping("/products/{productId}")
    public ModelAndView showProduct(@PathVariable("productId") int productId) {
        ModelAndView mav = new ModelAndView("products/productDetails");
        mav.addObject("product", this.products.findById(productId));
        return mav;
    }
}
