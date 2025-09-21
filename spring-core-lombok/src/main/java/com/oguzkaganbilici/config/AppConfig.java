package com.oguzkaganbilici.config;

import com.oguzkaganbilici.model.User;
import com.oguzkaganbilici.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();
        userList.add(new User("Oguz"));
        userList.add(new User("Kagan"));

        userService.setUserList(userList);

        return userService;
    }
}
