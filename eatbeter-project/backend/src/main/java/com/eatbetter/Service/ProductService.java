package com.eatbetter.Service;

import com.eatbetter.Entity.Product;
import com.eatbetter.Entity.User;
import com.eatbetter.Exceptions.ProductAlreadyExistsException;
import com.eatbetter.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(User user, Product product) throws ProductAlreadyExistsException {
        if(productRepository.findProductsByUserAndName(user, product.getName()) != null){
            throw new ProductAlreadyExistsException(product.getName()+" already exists");
        }
        product.setUser(user);
        productRepository.save(product);
    }

    public List<Product> getProducts(User user){
        return productRepository.findProductsByUser(user);
    }


}
