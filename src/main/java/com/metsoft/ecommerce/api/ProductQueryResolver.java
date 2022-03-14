package com.metsoft.ecommerce.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.metsoft.ecommerce.model.Product;
import com.metsoft.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueryResolver implements GraphQLQueryResolver {
    private final ProductRepository productRepository;

    public ProductQueryResolver(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
