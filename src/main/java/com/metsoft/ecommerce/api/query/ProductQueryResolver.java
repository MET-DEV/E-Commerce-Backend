package com.metsoft.ecommerce.api.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.metsoft.ecommerce.model.Product;
import com.metsoft.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductQueryResolver implements GraphQLQueryResolver {

    private ProductRepository productRepository;

    @Autowired
    public ProductQueryResolver(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }




}
