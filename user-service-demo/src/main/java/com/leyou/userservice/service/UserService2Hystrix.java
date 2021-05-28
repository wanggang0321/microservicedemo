package com.leyou.userservice.service;

import com.leyou.userservice.mapper.UserMapper;
import com.leyou.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Description TODO
 * @Author wanggang
 * @Date 2021年05月28日
 */
@Service
public class UserService2Hystrix {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) throws InterruptedException {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        Thread.sleep(new Random().nextInt(3000));
        return this.userMapper.selectByPrimaryKey(id);
    }

}
