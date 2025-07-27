package com.order_service.order_service.controller;


import com.order_service.order_service.dto.OrderResponseDTO;
import com.order_service.order_service.dto.ProductDTO;
import com.order_service.order_service.entity.Order;
import com.order_service.order_service.repository.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {


    @Autowired
    public OrderServiceRepository orderServiceRepository;

    @Autowired
    public WebClient.Builder webClientBuilder ;
    @PostMapping("/place-order")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order){
        return webClientBuilder.build().get().uri("http://localhost:8081/products/" + order.getProductId()).retrieve()
                .bodyToMono(ProductDTO.class).map(dto -> {
                    OrderResponseDTO orderResponseDTO = new OrderResponseDTO() ;
                    orderResponseDTO.setProductID(order.getProductId());
                    orderResponseDTO.setQuantity(order.getQuantity());
                    orderResponseDTO.setProductName(dto.getProductName());
                    orderResponseDTO.setProductPrice(dto.getPrice());
                    orderResponseDTO.setTotalAmount(dto.getPrice() * order.getQuantity());

                    orderServiceRepository.save(order) ;
                    orderResponseDTO.setOrderId(order.getId());
                    return ResponseEntity.ok(orderResponseDTO) ;
                }) ;
    }

    @GetMapping
    public List<Order> getAllOrder(){
        return orderServiceRepository.findAll();
    }
    @GetMapping("/test")
    public String test() {
        return "Orders service is up";
    }


}
