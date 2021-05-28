package com.leyou.userconsumer.controller;

import com.leyou.userconsumer.pojo.User;
import com.leyou.userconsumer.service.UserService;
import com.leyou.userconsumer.service.UserService2;
import com.leyou.userconsumer.service.UserService2Ribbon;
import com.leyou.userconsumer.service.UserService3Hystrix;
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
    @Autowired
    private UserService3Hystrix userService3;
    @Autowired
    private UserService2Ribbon userService2Ribbon;

    /**
     * 简单调用
     * @param ids
     * @return
     */
    @GetMapping
    public List<User> consume(@RequestParam("ids") List<Long> ids) {
        return userService.queryUserByIds(ids);
    }

    /**
     * 根据服务名称，获取服务实例
     * @param ids
     * @return
     */
    @GetMapping("/2")
    public List<User> consume2(@RequestParam("ids") List<Long> ids) {
        return userService2.queryUserByIds(ids);
    }

    /**
     * 触发熔断
     * @param ids
     * @return
     */
    @GetMapping("/3")
    public List<User> consume3(@RequestParam("ids") List<Long> ids) {
        return userService3.queryUserByIds(ids);
    }

    /**
     * Ribbon负载均衡
     * @param ids
     * @return
     */
    @GetMapping("/4")
    public List<User> consume4(@RequestParam("ids") List<Long> ids) {
        return userService2Ribbon.queryUserByIds(ids);
    }

}
