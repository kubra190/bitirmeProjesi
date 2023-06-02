package com.project.ecommerce.config;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] unsporttedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //Ürünler için http metodlarından POST, PUT, DELETE etkisiz hale getirelim..
        config.getExposureConfiguration().forDomainType(Product.class).
                withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsporttedActions)).
                withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsporttedActions));

        //Ürün kategorileri için http metodlarından POST, PUT, DELETE etkisiz hale getirelim..
        config.getExposureConfiguration().forDomainType(ProductCategory.class).
                withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsporttedActions)).
                withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsporttedActions));
        //java lambda syntax ->


    }
}
