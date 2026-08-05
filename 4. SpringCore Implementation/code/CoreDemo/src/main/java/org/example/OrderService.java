package org.example;

public class OrderService {

    EmailNotification notification =new EmailNotification();

    public void placeOrder(){

        System.out.println("Order placed");
        notification.sendNotification();
    }
}
