package com.leyou.userconsumer.service;

import com.leyou.userconsumer.dao.UserDao2Hystrix;
import com.leyou.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wanggang
 * @Date 2021年05月28日
 */
@Service
public class UserService3Hystrix {

    @Autowired
    private UserDao2Hystrix userDao;

    public List<User> queryUserByIds(List<Long> ids) {
        List<User> users = new ArrayList<>();
        ids.stream().forEach(id -> {
            User user = this.userDao.queryUserById(id);
            users.add(user);
        });
        return users;
    }

}
