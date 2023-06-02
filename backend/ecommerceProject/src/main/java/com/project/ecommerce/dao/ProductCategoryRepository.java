package com.project.ecommerce.dao;

import com.project.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product_category")
@Repository//en başta yazdığımız JSON entry diğeri /product_category
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> { //Entity ve primary key girdik


}
