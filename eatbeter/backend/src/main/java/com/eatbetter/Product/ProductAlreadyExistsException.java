package com.eatbetter.Product;

public class ProductAlreadyExistsException extends Exception{
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
