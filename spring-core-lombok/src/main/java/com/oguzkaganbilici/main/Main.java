package com.oguzkaganbilici.main;


import com.oguzkaganbilici.config.AppConfig;
import com.oguzkaganbilici.model.User;
import com.oguzkaganbilici.service.LoginService;
import com.oguzkaganbilici.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);

        for(User str : userService.getUserList()){
            System.out.println(str);
        }

        LoginService loginService = new LoginService();
        loginService.logIN();
    }
}
