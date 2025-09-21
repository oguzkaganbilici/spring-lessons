package com.oguzkaganbilici.service;

import com.oguzkaganbilici.config.AppConfig;
import com.oguzkaganbilici.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoginService {
    public void logIN() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        for (User usr : userService.getUserList()) {
            if(usr.getFirstName() == "Oguz"){
                System.out.println("Giris Basarili " + usr.getFirstName());
            }
        }
    }
}

