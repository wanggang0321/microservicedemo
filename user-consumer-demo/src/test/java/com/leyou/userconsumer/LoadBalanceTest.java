package com.leyou.userconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author wanggang
 * @Date 2021年05月28日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserConsumerDemoApplication.class)
public class LoadBalanceTest {

    @Autowired
    RibbonLoadBalancerClient client;

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            ServiceInstance instance = client.choose("user-service");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }

}
