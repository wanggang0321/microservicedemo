package com.leyou.userservice.controller;

import com.leyou.userservice.pojo.User;
import com.leyou.userservice.service.UserService;
import com.leyou.userservice.service.UserService2Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserService2Hystrix userService2;

    /**
     * 简单调用
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    /**
     * 触发熔断
     * @param id
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/2/{id}")
    public User queryById2(@PathVariable("id") Long id) throws InterruptedException {
        return userService2.queryById(id);
    }

}
