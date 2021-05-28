package com.leyou.userconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient // 不知道什么时候加上去的，教程缺失了一部分
@EnableEurekaClient // 开启EurekaClient功能
@EnableHystrix // 对hystrixR熔断机制的支持
@EnableFeignClients // 开启Feign功能
public class UserConsumerDemoApplication {

    /*
    RestTemplate的注册被删除了
    Feign中已经自动集成了Ribbon负载均衡，因此我们不需要自己定义RestTemplate了
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        // 这次我们使用了OkHttp客户端,只需要注入工厂即可
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
    */

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerDemoApplication.class, args);
    }

}
