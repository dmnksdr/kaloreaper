package org.springframework.samples.petclinic.Product;

import org.springframework.samples.petclinic.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory extends NamedEntity {

}
