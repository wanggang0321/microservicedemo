package com.leyou.userconsumer.dao;

import com.leyou.userconsumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author wanggang
 * @Date 2021年05月28日
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户查询出现异常！");
        return user;
    }

}
