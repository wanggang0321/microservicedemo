package com.leyou.userconsumer.controller;

import com.leyou.userconsumer.pojo.User;
import com.leyou.userconsumer.service.UserService;
import com.leyou.userconsumer.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consume")
public class ConsumerController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserService2 userService2;

    @GetMapping
    public List<User> consume(@RequestParam("ids") List<Long> ids) {
        return userService2.queryUserByIds(ids);
    }

}
