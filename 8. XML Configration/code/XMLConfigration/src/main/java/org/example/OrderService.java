package org.example;

import org.springframework.stereotype.Component;


public class OrderService {

    public OrderService(){
        System.out.println("Order Service Created");
    }

    public void placeOrder(){
        System.out.println("Order Placed");
    }
}
