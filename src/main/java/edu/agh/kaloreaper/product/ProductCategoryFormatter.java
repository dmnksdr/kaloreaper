package edu.agh.kaloreaper.product;


import edu.agh.kaloreaper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;


@Component
public class ProductCategoryFormatter implements Formatter<ProductCategory> {

    private final ProductRepository products;


    @Autowired
    public ProductCategoryFormatter(ProductRepository products) {
        this.products = products;
    }

    @Override
    public String print(ProductCategory productCategory, Locale locale) {
        return productCategory.getName();
    }

    @Override
    public ProductCategory parse(String text, Locale locale) throws ParseException {
        Collection<ProductCategory> findProductCategories = this.products.findProductCategories();
        for (ProductCategory category : findProductCategories) {
            if (category.getName().equals(text)) {
                return category;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

}
