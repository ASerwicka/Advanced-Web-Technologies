package com.eatbetter.Product;

import com.eatbetter.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void updateProduct(User user, Product product, Long id) throws Exception {

        Product productToUpdate = productRepository.findById(id).orElseThrow();
        if (productToUpdate.getUser().getId() != user.getId()) {
            throw new Exception("You are not allowed to update this product");
        }
        productToUpdate.setName(product.getName());
        productToUpdate.setCalories(product.getCalories());
        productToUpdate.setCarbohydrates(product.getCarbohydrates());
        productToUpdate.setProtein(product.getProtein());
        productToUpdate.setFat(product.getFat());
        productToUpdate.setSugar(product.getSugar());
        productToUpdate.setSalt(product.getSalt());
        productToUpdate.setUser(user);
        productRepository.save(productToUpdate);
    }

    public void deleteProduct(User user, Long id) {
        Product productToDelete = productRepository.findById(id).orElseThrow();
        if (productToDelete.getUser().getId() != user.getId()) {
            throw new RuntimeException("You are not allowed to delete this product");
        }
        productRepository.delete(productToDelete);
    }
}
