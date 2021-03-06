package com.leyou.userconsumer.dao;

import com.leyou.userconsumer.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

    //@Autowired
    private RestTemplate restTemplate;

    public User queryUserById(Long id) {
        String url = "http://localhost:8081/user/" + id;
        return this.restTemplate.getForObject(url, User.class);
    }

}
