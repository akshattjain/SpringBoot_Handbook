package org.example;

import org.example.notification.EmailNotification;
import org.example.notification.Notification;
import org.example.notification.SmsService;

public class OrderService {

    Notification notification;

    public OrderService(Notification notification){
        this.notification =notification;
    }

    public void placeOrder(){

        System.out.println("Order placed");
        notification.sendNotification();
    }
}
