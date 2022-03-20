package com.metsoft.ecommerce.api.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.metsoft.ecommerce.model.Product;
import com.metsoft.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductMutationResolver implements GraphQLMutationResolver {

    private final ProductRepository productRepository;
    @Autowired
    public ProductMutationResolver(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product saveProduct(Product product){
        product.setCreateDate(new Date());
        return productRepository.save(product);
    }


    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product Deleted";
    }
}
