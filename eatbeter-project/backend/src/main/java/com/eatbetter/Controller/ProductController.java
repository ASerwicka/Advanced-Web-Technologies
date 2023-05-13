package com.eatbetter.Controller;

import com.eatbetter.Entity.Product;
import com.eatbetter.Entity.User;
import com.eatbetter.Exceptions.ProductAlreadyExistsException;
import com.eatbetter.Service.ProductService;
import com.eatbetter.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @PostMapping("/addProduct")
    public String addProduct(Principal principal, @RequestBody Product product) throws ProductAlreadyExistsException {
        User user = userService.findByPrincipal(principal).orElseThrow();
        product.setUser(user);
        productService.addProduct(user, product);
        return "redirect:/dupa";
    }

    @GetMapping(value = "/getProducts")
    public ResponseEntity<String> getProducts(Principal principal){
        User user = userService.findByPrincipal(principal).orElseThrow();
        List<Product> products= productService.getProducts(user);
        return ResponseEntity.ok(products.toString());
    }


}
