package com.product_service.product_service.service;


import com.product_service.product_service.entity.Product;

public interface ProductService {

    Product addProduct(Product product) ;
    Product getProduct(String Id) ;
    void deleteProduct(String Id);
}
