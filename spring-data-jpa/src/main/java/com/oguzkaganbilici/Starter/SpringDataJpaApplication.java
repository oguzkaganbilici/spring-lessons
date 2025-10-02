package com.oguzkaganbilici.Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.oguzkaganbilici"})
@EntityScan(basePackages = {"com.oguzkaganbilici"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.oguzkaganbilici"})
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
