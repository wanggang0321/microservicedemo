package com.leyou.userconsumer.dao;

import com.leyou.userconsumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Author wanggang
 * @Date 2021年05月28日
 */
@Component
public class UserDao2Hystrix {

    //@Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Long id) {
        long begin = System.currentTimeMillis();
        String url = "http://user-service/user/2/" + id;
        User user = restTemplate.getForObject(url, User.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return user;
    }

    public User queryUserByIdFallback(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常！");
        return user;
    }

}
