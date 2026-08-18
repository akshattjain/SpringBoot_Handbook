package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements BeanNameAware, ApplicationContextAware {

    public void userService() {
        System.out.println("UserService Constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is "+name);
    }

    private String getBean(){
        return "UserBean";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application COntext is "+applicationContext.getClass());
    }
}
