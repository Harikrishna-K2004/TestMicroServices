package com.product_service.product_service.repository;


import com.product_service.product_service.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepository extends MongoRepository<Product , String> {
}
