package com.order_service.order_service.repository;


import com.order_service.order_service.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends MongoRepository<Order , String> {
}
