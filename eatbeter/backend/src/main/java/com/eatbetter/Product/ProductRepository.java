package com.eatbetter.Product;

import com.eatbetter.Product.Product;
import com.eatbetter.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByUser(User user);
    Product findProductsByUserAndName(User user, String name);
    void removeProductByUserAndName(User user, String name);
    void removeProductByUser(User user);

}
