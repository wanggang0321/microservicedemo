package com.leyou.userconsumer.dao;

import com.leyou.userconsumer.config.FeignConfig;
import com.leyou.userconsumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description TODO
 * @Author wanggang
 * @Date 2021年05月28日
 */
@FeignClient(value = "user-service",
        fallback = UserFeignClientFallback.class,
        configuration = FeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User queryUserById(@PathVariable("id") Long id);

}
