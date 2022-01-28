package com.supergo.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/28
 * @Description:com.supergo.manager
 * @version:1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.supergo.manager.feign")
public class ManagerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApplication.class,args);
    }
}
