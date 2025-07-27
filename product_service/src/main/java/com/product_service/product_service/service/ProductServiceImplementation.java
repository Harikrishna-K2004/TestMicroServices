package com.product_service.product_service.service;

import com.product_service.product_service.entity.Product;
import com.product_service.product_service.repository.ProductServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImplementation implements ProductService {


    @Autowired
    public ProductServiceRepository productServiceRepository;


    @Override
    public Product addProduct(Product product) {
        return productServiceRepository.save(product) ;
    }

    @Override
    public Product getProduct(String id) {
        return productServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(String Id) {
        productServiceRepository.deleteById(Id);
    }
}
