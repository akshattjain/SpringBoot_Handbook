package org.example.notification;

public class FakeNotification implements Notification{

    @Override
    public void sendNotification(){
        System.out.println("Dummy Email sent");
    }
}
