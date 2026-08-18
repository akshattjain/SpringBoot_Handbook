package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;
@Component
public class CartService {

    Map<Integer,String> mp;

    public CartService(){
        mp=new HashMap<>();

        System.out.println("CartService Constructor called ");
    }

    @PostConstruct
    public void start(){
        System.out.println("Bean is ready");
        mp.put(1,"Akshat");
        mp.put(2,"Jain");
    }

    public String getValue(int key){
        return mp.get(key);
    }
}
