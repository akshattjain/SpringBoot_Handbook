package org.example;

import org.example.notification.EmailNotification;
import org.example.notification.FakeNotification;
import org.example.notification.Notification;
import org.example.notification.SmsService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Notification notification=new FakeNotification();

        OrderService order=new OrderService(notification);
        order.placeOrder();
    }
}