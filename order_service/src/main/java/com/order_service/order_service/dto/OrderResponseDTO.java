package com.order_service.order_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private String orderId;
    private String productID;
    private Long quantity;
    private Double totalAmount;
    private String productName;
    private Double productPrice;
}
