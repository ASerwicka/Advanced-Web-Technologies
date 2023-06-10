package com.eatbetter.Product;

import com.eatbetter.User.User;
import com.eatbetter.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(Principal principal, @RequestBody Product product) throws ProductAlreadyExistsException {
        User user = userService.findByPrincipal(principal).orElseThrow();
        product.setUser(user);
        productService.addProduct(user, product);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping(value = "/getProducts")
    public ResponseEntity<String> getProducts(Principal principal){
        User user = userService.findByPrincipal(principal).orElseThrow();
        List<Product> products= productService.getProducts(user);
        return ResponseEntity.ok(products.toString());
    }


    @PutMapping(value = "/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(Principal principal, @RequestBody Product product,@PathVariable Long id) throws Exception {
        User user = userService.findByPrincipal(principal).orElseThrow();
        try {
            productService.updateProduct(user, product, id);
            return ResponseEntity.ok("Product updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(Principal principal, @PathVariable Long id) throws Exception {
        User user = userService.findByPrincipal(principal).orElseThrow();
        try {
            productService.deleteProduct(user, id);
            return ResponseEntity.ok("Product deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
