package com.leyou.userconsumer.service;

import com.leyou.userconsumer.dao.UserDao;
import com.leyou.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryUserByIds(List<Long> ids) {
        List<User> users = new ArrayList<>();
        ids.stream().forEach(id -> {
            User user = this.userDao.queryUserById(id);
            users.add(user);
        });
        return users;
    }

}
