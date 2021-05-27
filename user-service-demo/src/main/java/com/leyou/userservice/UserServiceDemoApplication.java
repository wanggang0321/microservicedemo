package com.leyou.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 开启EurekaClient功能
public class UserServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceDemoApplication.class, args);
    }

}
